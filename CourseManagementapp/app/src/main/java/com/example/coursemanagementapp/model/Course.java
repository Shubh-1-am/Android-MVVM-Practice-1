package com.example.coursemanagementapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.coursemanagementapp.BR;

@Entity(tableName = "courses_table", foreignKeys = @ForeignKey(entity = Category.class,
        parentColumns = "id",
        childColumns = "category_id",
        onDelete = ForeignKey.CASCADE))
public class Course extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "course_id")
    private String courseId;
    @ColumnInfo(name = "course_name")
    private String courseName;
    @ColumnInfo(name = "unit_price")
    private String unitPrice;
    @ColumnInfo(name = "category_id")
    private int categoryId;

    @Ignore
    public Course() {
    }

    public Course(String courseId, String courseName, String unitPrice, int categoryId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
    }

    @Bindable
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
        notifyPropertyChanged(BR.courseId);
    }

    @Bindable
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
        notifyPropertyChanged(BR.courseName);
    }

    @Bindable
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        notifyPropertyChanged(BR.unitPrice);
    }

    @Bindable
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        notifyPropertyChanged(BR.categoryId);
    }
}