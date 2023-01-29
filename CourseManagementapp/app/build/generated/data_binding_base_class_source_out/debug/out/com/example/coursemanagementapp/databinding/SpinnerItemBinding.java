// Generated by data binding compiler. Do not edit!
package com.example.coursemanagementapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.coursemanagementapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SpinnerItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView textView;

  protected SpinnerItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView textView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.textView = textView;
  }

  @NonNull
  public static SpinnerItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.spinner_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SpinnerItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SpinnerItemBinding>inflateInternal(inflater, R.layout.spinner_item, root, attachToRoot, component);
  }

  @NonNull
  public static SpinnerItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.spinner_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SpinnerItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SpinnerItemBinding>inflateInternal(inflater, R.layout.spinner_item, null, false, component);
  }

  public static SpinnerItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static SpinnerItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (SpinnerItemBinding)bind(component, view, R.layout.spinner_item);
  }
}
