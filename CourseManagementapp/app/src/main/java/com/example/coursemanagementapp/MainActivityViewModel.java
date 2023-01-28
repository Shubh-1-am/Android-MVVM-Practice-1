package com.example.coursemanagementapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coursemanagementapp.model.Category;
import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.model.CourseShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private CourseShopRepository repository;

    private LiveData<List<Category>> allCategories;
    private LiveData<List<Course>> allCourses;



    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new CourseShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        return repository.getAllCategories();
    }

    public LiveData<List<Course>> getAllCourses(int categoryId) {
        return repository.getAllCourses(categoryId);
    }

    public void addNewCourse(Course course){
        repository.insertCourse(course);
    }

    public void addNewCategory(Category category){
        repository.insertCategory(category);
    }

    public void updateCourse(Course course){
        repository.updateCourse(course);
    }

    public void updateCategory(Category category){
        repository.updateCategory(category);
    }

    public void deleteCourse(Course course){
        repository.deleteCourse(course);
    }

    public void deleteCategory(Category category){
        repository.deleteCategory(category);
    }




}
