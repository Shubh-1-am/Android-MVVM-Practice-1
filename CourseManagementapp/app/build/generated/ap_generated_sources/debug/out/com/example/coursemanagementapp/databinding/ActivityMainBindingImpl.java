package com.example.coursemanagementapp.databinding;
import com.example.coursemanagementapp.R;
import com.example.coursemanagementapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(3);
        sIncludes.setIncludes(0, 
            new String[] {"content_main"},
            new int[] {2},
            new int[] {com.example.coursemanagementapp.R.layout.content_main});
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickHandlerOnFabClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[1]
            , (com.example.coursemanagementapp.databinding.ContentMainBinding) bindings[2]
            );
        this.fab.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setContainedBinding(this.secondaryLayout);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        secondaryLayout.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (secondaryLayout.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.spinnerAdapter == variableId) {
            setSpinnerAdapter((android.widget.ArrayAdapter) variable);
        }
        else if (BR.clickHandler == variableId) {
            setClickHandler((com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSpinnerAdapter(@Nullable android.widget.ArrayAdapter SpinnerAdapter) {
        this.mSpinnerAdapter = SpinnerAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.spinnerAdapter);
        super.requestRebind();
    }
    public void setClickHandler(@Nullable com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers ClickHandler) {
        this.mClickHandler = ClickHandler;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.clickHandler);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        secondaryLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSecondaryLayout((com.example.coursemanagementapp.databinding.ContentMainBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSecondaryLayout(com.example.coursemanagementapp.databinding.ContentMainBinding SecondaryLayout, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        android.widget.ArrayAdapter<?> spinnerAdapter = mSpinnerAdapter;
        com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers clickHandler = mClickHandler;
        android.view.View.OnClickListener clickHandlerOnFabClickedAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0xaL) != 0) {
        }
        if ((dirtyFlags & 0xcL) != 0) {



                if (clickHandler != null) {
                    // read clickHandler::onFabClicked
                    clickHandlerOnFabClickedAndroidViewViewOnClickListener = (((mClickHandlerOnFabClickedAndroidViewViewOnClickListener == null) ? (mClickHandlerOnFabClickedAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickHandlerOnFabClickedAndroidViewViewOnClickListener).setValue(clickHandler));
                }
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.fab.setOnClickListener(clickHandlerOnFabClickedAndroidViewViewOnClickListener);
            this.secondaryLayout.setSecondaryClickHandler(clickHandler);
        }
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            this.secondaryLayout.setSecondarySpinnerAdapter(spinnerAdapter);
        }
        executeBindingsOn(secondaryLayout);
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers value;
        public OnClickListenerImpl setValue(com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onFabClicked(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): secondaryLayout
        flag 1 (0x2L): spinnerAdapter
        flag 2 (0x3L): clickHandler
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}