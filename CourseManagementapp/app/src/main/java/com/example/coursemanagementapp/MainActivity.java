package com.example.coursemanagementapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

    private RecyclerView courseRecyclerView;
    private CourseAdapter courseAdapter;
    private static final int ADD_COURSE_REQUEST_CODE = 1;
    private static final int EDIT_COURSE_REQUEST_CODE = 2;

    private int selectedCourseId;
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
        }
        );

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

    public void LoadCoursesArrayList(int CategoryId) {
        viewModel.getAllCourses(CategoryId).observe(this, courses -> {
            // Update UI
            courseList = (ArrayList<Course>) courses;
            LoadRecyclerView();
        });
    }

    private void LoadRecyclerView() {
        courseRecyclerView = activityMainBinding.secondaryLayout.recyclerView;
        courseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseRecyclerView.setHasFixedSize(true);
        courseAdapter = new CourseAdapter();
        courseRecyclerView.setAdapter(courseAdapter);
        courseAdapter.setCourses(courseList);

        // Edit course
        courseAdapter.setOnItemClickListener(new CourseAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Course course) {
                selectedCourseId = course.getCourseId();
                Intent i = new Intent(MainActivity.this, AddEditActivity.class);
                i.putExtra(AddEditActivity.COURSE_ID, selectedCourseId);
                i.putExtra(AddEditActivity.COURSE_NAME, course.getCourseName());
                i.putExtra(AddEditActivity.UNIT_PRICE, course.getUnitPrice());
                startActivityForResult(i, EDIT_COURSE_REQUEST_CODE);
            }
        });

        // Delete course
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Course courseToDelete = courseList.get(viewHolder.getAdapterPosition());
                viewModel.deleteCourse(courseToDelete);
                Toast.makeText(MainActivity.this, "Course deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(courseRecyclerView);
    }

    public class MainActivityClickHandlers {
        public void onFabClicked(View view) {
            // Add a new category
            Intent intent = new Intent(MainActivity.this, AddEditActivity.class);

            startActivityForResult(intent, ADD_COURSE_REQUEST_CODE);
        }

        public void onSelectItem(AdapterView<?> parent, View view, int position, long id) {
            // Get the selected category
            selectedCategory = (Category) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "Selected category: " + selectedCategory.getCategoryName(), Toast.LENGTH_SHORT).show();
            LoadCoursesArrayList(selectedCategory.getId());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        int selectedCategoryId = selectedCategory.getId();


        if (requestCode == ADD_COURSE_REQUEST_CODE && resultCode == RESULT_OK){
            Course course = new Course();

            course.setCategoryId(selectedCategoryId);
            course.setCourseName(data.getStringExtra(AddEditActivity.COURSE_NAME));
            course.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));
            viewModel.addNewCourse(course);
            Log.v("TAG", "Inserted"+course.getUnitPrice());
        }
        else if(requestCode == EDIT_COURSE_REQUEST_CODE && resultCode == RESULT_OK){

            Course course = new Course();
            course.setCategoryId(selectedCategoryId);
            course.setCourseName(data.getStringExtra(AddEditActivity.COURSE_NAME));
            course.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));

            course.setCourseId(selectedCourseId);

            viewModel.updateCourse(course);

        }



    }
}