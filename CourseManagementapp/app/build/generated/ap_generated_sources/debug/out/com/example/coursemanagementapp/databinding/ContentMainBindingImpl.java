package com.example.coursemanagementapp.databinding;
import com.example.coursemanagementapp.R;
import com.example.coursemanagementapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentMainBindingImpl extends ContentMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.recyclerView, 2);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    private OnItemSelectedImpl mSecondaryClickHandlerOnSelectItemAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected;
    // Inverse Binding Event Handlers

    public ContentMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ContentMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (android.widget.Spinner) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.spinner.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.secondarySpinnerAdapter == variableId) {
            setSecondarySpinnerAdapter((android.widget.ArrayAdapter) variable);
        }
        else if (BR.secondaryClickHandler == variableId) {
            setSecondaryClickHandler((com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSecondarySpinnerAdapter(@Nullable android.widget.ArrayAdapter SecondarySpinnerAdapter) {
        this.mSecondarySpinnerAdapter = SecondarySpinnerAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.secondarySpinnerAdapter);
        super.requestRebind();
    }
    public void setSecondaryClickHandler(@Nullable com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers SecondaryClickHandler) {
        this.mSecondaryClickHandler = SecondaryClickHandler;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.secondaryClickHandler);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected secondaryClickHandlerOnSelectItemAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected = null;
        android.widget.ArrayAdapter<?> secondarySpinnerAdapter = mSecondarySpinnerAdapter;
        com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers secondaryClickHandler = mSecondaryClickHandler;

        if ((dirtyFlags & 0x5L) != 0) {
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (secondaryClickHandler != null) {
                    // read secondaryClickHandler::onSelectItem
                    secondaryClickHandlerOnSelectItemAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected = (((mSecondaryClickHandlerOnSelectItemAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected == null) ? (mSecondaryClickHandlerOnSelectItemAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected = new OnItemSelectedImpl()) : mSecondaryClickHandlerOnSelectItemAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected).setValue(secondaryClickHandler));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            this.spinner.setAdapter(secondarySpinnerAdapter);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.AdapterViewBindingAdapter.setOnItemSelectedListener(this.spinner, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected)secondaryClickHandlerOnSelectItemAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected)null, (androidx.databinding.InverseBindingListener)null);
        }
    }
    // Listener Stub Implementations
    public static class OnItemSelectedImpl implements androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected{
        private com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers value;
        public OnItemSelectedImpl setValue(com.example.coursemanagementapp.MainActivity.MainActivityClickHandlers value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onItemSelected(android.widget.AdapterView arg0, android.view.View arg1, int arg2, long arg3) {
            this.value.onSelectItem(arg0, arg1, arg2, arg3); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): secondarySpinnerAdapter
        flag 1 (0x2L): secondaryClickHandler
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}