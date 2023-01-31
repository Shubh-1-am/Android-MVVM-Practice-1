package com.example.coursemanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.coursemanagementapp.databinding.ActivityAddEditBinding;
import com.example.coursemanagementapp.model.Course;

public class AddEditActivity extends AppCompatActivity {


    private Course course;
    public static final String COURSE_ID = "course_id";
    public static final String COURSE_NAME = "course_name";
    public static final String UNIT_PRICE = "unit_price";
    private ActivityAddEditBinding activityAddEditBinding;
    private AddEditActivityClickHandlers clickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        course = new Course();
        activityAddEditBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit);
        activityAddEditBinding.setCourse(course);
        clickHandlers = new AddEditActivityClickHandlers(this);
        activityAddEditBinding.setClickHandler(clickHandlers);

        Intent i = getIntent();
        if (i.hasExtra(COURSE_ID)){
            setTitle("Edit Course");
            course.setCourseName(i.getStringExtra(COURSE_NAME));
            course.setUnitPrice(i.getStringExtra(UNIT_PRICE));

        } else {
            setTitle("Add new Course");
        }
    }

    public class AddEditActivityClickHandlers{
        Context context;

        public AddEditActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onSubmitClicked(View view){
            if (course.getCourseName() == null){
                Toast.makeText(context, "Course name is Empty!", Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent();
                i.putExtra(COURSE_NAME, course.getCourseName());
                i.putExtra(UNIT_PRICE, course.getUnitPrice());
                setResult(RESULT_OK, i);
                finish();
            }
        }
    }
}