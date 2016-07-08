package com.example.anhlk.communicationfragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by AnhLK on 7/7/2016.
 */
public class FragmentThree extends Fragment implements View.OnClickListener{
    FragmentTwo fragmentTwo;
    Fragment targetFragment;
    Button mButton;
    int age;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        targetFragment = getTargetFragment();
        if(targetFragment instanceof FragmentTwo){
            fragmentTwo = (FragmentTwo) targetFragment;
        }
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        age = fragmentTwo.getAge();
        mButton = (Button) view.findViewById(R.id.back);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.back:
                age = age+200;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra(FragmentTwo.RESULT_KEY,age);
        fragmentTwo.onActivityResult(FragmentTwo.REQUEST_CODE, FragmentTwo.RESULT_CODE, intent);
        getFragmentManager().popBackStack();

    };
}
