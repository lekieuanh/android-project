package com.example.anhlk.communicationfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by AnhLK on 7/7/2016.
 */
public class FragmentTwo extends Fragment  {
    TextView textView;
    Button button;
    EditText editText;
    TextView title;
    int age = 0;
    public final static int REQUEST_CODE = 0;
    public final static int RESULT_CODE = 1;
    public final static String RESULT_KEY = "key";
    int value;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        return view ;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        textView = (TextView) view.findViewById(R.id.txt_displayname);
        textView.setVisibility(View.GONE);
        editText = (EditText) view.findViewById(R.id.txt_age) ;
        button = (Button) view.findViewById(R.id.btn_go);

        final FragmentThree fragmentThree = new FragmentThree();
        fragmentThree.setTargetFragment(this,REQUEST_CODE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_two, fragmentThree);
                fragmentTransaction.addToBackStack(null).commit();
            }
        });

        title = (TextView) view.findViewById(R.id.txt_title);
        if(age!=0){
            title.setText(String.valueOf(age));
        }
    }

    public void updateInfo(String name){
        textView.setText("Welcome "+name);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_CODE){
            age = data.getIntExtra(RESULT_KEY,0);
        }
    }

    public int getAge(){
        return Integer.valueOf(editText.getText().toString());
    }
}
