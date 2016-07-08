package com.example.anhlk.communicationfragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AnhLK on 7/7/2016.
 */
public class FragmentOne extends Fragment {
    onNameSetListener onNameSetListener;
    EditText editText;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        editText = (EditText) view.findViewById(R.id.name);
        button = (Button) view.findViewById(R.id.btn_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                onNameSetListener.setName(name);
                onNameSetListener.setColor("red");
            }
        });
        return view ;
    }
    public interface onNameSetListener{
        public void setName(String name);
        public void setColor(String color);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            onNameSetListener = (FragmentOne.onNameSetListener) activity;
        }catch (Exception e){}
    }

}
