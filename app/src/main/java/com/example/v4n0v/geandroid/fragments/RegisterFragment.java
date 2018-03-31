package com.example.v4n0v.geandroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.v4n0v.geandroid.R;

/**
 * Created by v4n0v on 06.03.18.
 */

public class RegisterFragment extends Fragment implements View.OnTouchListener{

    private EditText phoneEditText;
    private EditText nameEditText;
    private  EditText mailEditText;
    private  Button acceptButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initViews(view);

        return view;
    }

    void initViews(View view){
        phoneEditText =view.findViewById(R.id.editTextPhone);
        mailEditText =view.findViewById(R.id.editTextMail);
        nameEditText=view.findViewById(R.id.editTextName);
        acceptButton=view.findViewById(R.id.accept_reg_button);
        acceptButton.setOnTouchListener(this);
    }


    public void confirmRegistration(View view) {
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String mail = mailEditText.getText().toString();

        if (!name.equals("") && !phone.equals("") && !mail.equals("")) {
            Toast.makeText(getActivity(), "Регистрация: " + name +"\n"+phone+"\n"+mail, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Заполните все поля", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id==R.id.accept_reg_button){
            Toast.makeText(getActivity(), "Рега", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }


}
