package com.example.anhlk.fragmentdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements ColorFragment.onColorChangeListener {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ColorFragment colorFragment = new ColorFragment();
        fragmentTransaction.add(R.id.fragment_container,colorFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void colorChange(String color_name) {
        if(color_name.equals("red")){
            linearLayout.setBackgroundColor(Color.RED);
        }
        else if(color_name.equals("yellow")){
            linearLayout.setBackgroundColor(Color.YELLOW);
        }
        else if(color_name.equals("green")){
            linearLayout.setBackgroundColor(Color.GREEN);
        }
    }
}
