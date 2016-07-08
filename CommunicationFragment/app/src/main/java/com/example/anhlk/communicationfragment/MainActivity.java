package com.example.anhlk.communicationfragment;

import android.app.FragmentManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements FragmentOne.onNameSetListener {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);

        getFragmentManager().beginTransaction().replace(R.id.fragment_one, new FragmentOne()).commit();
        getFragmentManager().beginTransaction().replace(R.id.fragment_two, new FragmentTwo()).commit();

    }

    @Override
    public void setName(String name) {
        FragmentTwo f2 = (FragmentTwo) getFragmentManager().findFragmentById(R.id.fragment_two);
        f2.updateInfo(name);
    }

    @Override
    public void setColor(String color) {
        if(color.equals("red")){
            linearLayout.setBackgroundColor(Color.GREEN);
        }
    }

}
