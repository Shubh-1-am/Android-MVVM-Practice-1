package com.example.coursemanagementapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.coursemanagementapp.databinding.ActivityAddEditBindingImpl;
import com.example.coursemanagementapp.databinding.ActivityMainBindingImpl;
import com.example.coursemanagementapp.databinding.ContentMainBindingImpl;
import com.example.coursemanagementapp.databinding.CourseListItemBindingImpl;
import com.example.coursemanagementapp.databinding.SpinnerItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDEDIT = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_CONTENTMAIN = 3;

  private static final int LAYOUT_COURSELISTITEM = 4;

  private static final int LAYOUT_SPINNERITEM = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.coursemanagementapp.R.layout.activity_add_edit, LAYOUT_ACTIVITYADDEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.coursemanagementapp.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.coursemanagementapp.R.layout.content_main, LAYOUT_CONTENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.coursemanagementapp.R.layout.course_list_item, LAYOUT_COURSELISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.coursemanagementapp.R.layout.spinner_item, LAYOUT_SPINNERITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYADDEDIT: {
          if ("layout/activity_add_edit_0".equals(tag)) {
            return new ActivityAddEditBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_edit is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_CONTENTMAIN: {
          if ("layout/content_main_0".equals(tag)) {
            return new ContentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_main is invalid. Received: " + tag);
        }
        case  LAYOUT_COURSELISTITEM: {
          if ("layout/course_list_item_0".equals(tag)) {
            return new CourseListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for course_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_SPINNERITEM: {
          if ("layout/spinner_item_0".equals(tag)) {
            return new SpinnerItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for spinner_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(13);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "categoryDescription");
      sKeys.put(2, "categoryId");
      sKeys.put(3, "categoryName");
      sKeys.put(4, "clickHandler");
      sKeys.put(5, "course");
      sKeys.put(6, "courseId");
      sKeys.put(7, "courseName");
      sKeys.put(8, "id");
      sKeys.put(9, "secondaryClickHandler");
      sKeys.put(10, "secondarySpinnerAdapter");
      sKeys.put(11, "spinnerAdapter");
      sKeys.put(12, "unitPrice");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_add_edit_0", com.example.coursemanagementapp.R.layout.activity_add_edit);
      sKeys.put("layout/activity_main_0", com.example.coursemanagementapp.R.layout.activity_main);
      sKeys.put("layout/content_main_0", com.example.coursemanagementapp.R.layout.content_main);
      sKeys.put("layout/course_list_item_0", com.example.coursemanagementapp.R.layout.course_list_item);
      sKeys.put("layout/spinner_item_0", com.example.coursemanagementapp.R.layout.spinner_item);
    }
  }
}
