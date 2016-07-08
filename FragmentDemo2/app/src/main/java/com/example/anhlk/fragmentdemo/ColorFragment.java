package com.example.anhlk.fragmentdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by AnhLK on 7/6/2016.
 */
public class ColorFragment extends Fragment {
    RadioGroup color_group;
    onColorChangeListener onColorChangeListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.color_fragment,container,false);
        color_group = (RadioGroup) view.findViewById(R.id.color_group);
        color_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.red:
                        onColorChangeListener.colorChange("red");
                        break;
                    case R.id.yellow:
                        onColorChangeListener.colorChange("yellow");
                        break;
                    case R.id.green:
                        onColorChangeListener.colorChange("green");
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            onColorChangeListener = (ColorFragment.onColorChangeListener) activity;
        }catch (Exception ex){

        }
    }

    public interface onColorChangeListener{
        public void colorChange(String color_name);
    }
}
