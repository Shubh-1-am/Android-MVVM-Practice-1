package com.example.coursemanagementapp.model;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Category.class, Course.class}, version = 1, exportSchema = false)
public abstract class CourseDatabase extends RoomDatabase {

    public abstract CategoryDao categoryDao();
    public abstract CourseDao courseDao();

    private static CourseDatabase instance;

    public static synchronized CourseDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CourseDatabase.class, "course_database")
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // Add some initial data
            initializeData();
        }
    };

    private static void initializeData() {
        // Add some initial data

        CourseDao courseDao = instance.courseDao();
        CategoryDao categoryDao = instance.categoryDao();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDao.insert(new Category(1, "Android", "Android Development"));
                categoryDao.insert(new Category(2, "iOS", "iOS Development"));
                categoryDao.insert(new Category(3, "Web", "Web Development"));
                categoryDao.insert(new Category(4, "Java", "Java Development"));
                categoryDao.insert(new Category(5, "Python", "Python Development"));

                //courses
                courseDao.insert(new Course(1, "Android Development", "Android Development", 1));
                courseDao.insert(new Course(2, "iOS Development", "iOS Development course", 2));
                courseDao.insert(new Course(3, "Web Development", "Web Development course", 3));
                courseDao.insert(new Course(4, "Java Development", "Java Development course", 4));
                courseDao.insert(new Course(5, "Android in java", "Android in java course", 1));
                courseDao.insert(new Course(6, "Android in kotlin", "Android in kotlin course", 1));
                courseDao.insert(new Course(7, "Android in python", "Android in python course", 1));


            }
        });
    }

}
