package com.example.coursemanagementapp.model;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CourseShopRepository {

    private CourseDao courseDao;
    private CategoryDao categoryDao;
    private LiveData<List<Course>> allCourses;
    private LiveData<List<Category>> allCategories;

    public CourseShopRepository(Application application){
        CourseDatabase database = CourseDatabase.getInstance(application);
        courseDao = database.courseDao();
        categoryDao = database.categoryDao();

    }

    public LiveData<List<Course>> getAllCourses(int categoryId) {
        return courseDao.getAllCoursesByCategoryId(categoryId);
    }

    public LiveData<List<Category>> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    public   void insertCategory(Category category){
        categoryDao.insert(category);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> categoryDao.insert(category));
    }

    public  void insertCourse(Course course){
        courseDao.insert(course);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                // Background work here
                courseDao.insert(course);

                // Do after background execution is done - post execution

            }
        });
    }

    public void deleteCategory(Category category){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                // Background work here
                categoryDao.delete(category);

                // Do after background execution is done - post execution

            }
        });
    }

    public void deleteCourse(Course course){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> courseDao.delete(course));
    }

    public  void updateCategory(Category category){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> categoryDao.update(category));
    }

    public  void updateCourse(Course course){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> courseDao.update(course));
    }
}
