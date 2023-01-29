package com.example.coursemanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.coursemanagementapp.ViewModel.MainActivityViewModel;
import com.example.coursemanagementapp.databinding.ActivityMainBinding;
import com.example.coursemanagementapp.model.Category;
import com.example.coursemanagementapp.model.Course;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private ArrayList<Category> categoryList;
    private ArrayList<Course> courseList;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers clickHandlers;

    private Category selectedCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        clickHandlers = new MainActivityClickHandlers();

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setClickHandler(clickHandlers);

        viewModel.getAllCategories().observe(this, categories -> {
            // Update UI

            categoryList = (ArrayList<Category>) categories;
            for (Category category : categories) {
                Log.i("TAG", category.getCategoryName());
            }

            showOnSpinner();
        });

        viewModel.getAllCourses(1).observe(this, courses -> {
            // Update UI
            for (Course course : courses)
                Log.d("TAG", course.getCourseName());
        });
    }

    private void showOnSpinner() {
        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, categoryList);
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityMainBinding.setSpinnerAdapter(categoryArrayAdapter);
    }

    public class MainActivityClickHandlers {
        public void onFabClicked(View view) {
            // Add a new category
            Toast.makeText(getApplicationContext(), "On FAB clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onSelectItem(AdapterView<?> parent, View view, int position, long id) {
            // Get the selected category
            selectedCategory = (Category) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "Selected category: " + selectedCategory.getCategoryName(), Toast.LENGTH_SHORT).show();
        }
    }
}