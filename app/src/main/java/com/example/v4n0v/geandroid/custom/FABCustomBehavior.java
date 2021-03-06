package com.example.v4n0v.geandroid.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class FABCustomBehavior extends FloatingActionButton.Behavior{

    final private String TAG = "FAB_CUSTOM";

    public FABCustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.d(TAG, "onNested");
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);

    }

    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int type) {

        child.animate().translationX(0).scaleX(1).scaleY(1).setDuration(300).start();
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull FloatingActionButton child,
                                       @NonNull View directTargetChild,
                                       @NonNull View target,
                                       int axes, int type) {

        Log.d(TAG, "onStartNested");

        child.animate().translationX(250).scaleX(0).scaleY(0).setDuration(300).start();


        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }
}
