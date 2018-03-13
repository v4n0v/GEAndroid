package com.example.v4n0v.geandroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.v4n0v.geandroid.R;

/**
 * Created by v4n0v on 06.03.18.
 */

public class AddToCartFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_to_cart_fragment, container, false);
        initViews(view);

        return view;
    }


    private void initViews(View view) {

    }

}
