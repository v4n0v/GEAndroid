package com.example.v4n0v.geandroid.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by v4n0v on 16.03.18.
 */

public class BottomCustom extends BottomSheetBehavior{
    public BottomCustom(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    //private final View view;



    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.d("TAG", "dyConsumed = "+dyConsumed);
        if (dyConsumed != 0) {
         //   view.setVisibility(View.INVISIBLE);child.getVisibility() == View.VISIBLE &&
            child.animate().translationY(250).setDuration(300).start();
         //   child.setVisibility(View.INVISIBLE); child.getVisibility() == View.INVISIBLE &&

        } else if (dyConsumed == 0) {
      //      view.setVisibility(View.VISIBLE);

            child.animate().translationY(0).setDuration(300).start();
           // child.setVisibility(View.VISIBLE);
        }
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }
}
