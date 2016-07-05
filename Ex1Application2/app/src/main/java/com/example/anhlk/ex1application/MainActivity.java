package com.example.anhlk.ex1application;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    static final int request_code = 1;
    EditText username;
    EditText age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            String txt_username = savedInstanceState.getString("txt_username");
                EditText name = (EditText) findViewById(R.id.username);
                name.setText(txt_username);
            Integer txt_age = savedInstanceState.getInt("txt_age");
                EditText age = (EditText) findViewById(R.id.age);
                age.setText(txt_age.toString());
        }
    }
    public void onClick(View view){
        username = (EditText) findViewById(R.id.username);
        age = (EditText) findViewById(R.id.age);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("username", username.getText().toString());
        intent.putExtra("age",Integer.parseInt(age.getText().toString()));

        startActivityForResult(intent,request_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == request_code && resultCode == RESULT_OK){
            Toast.makeText(this, data.getStringExtra("str"),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        username = (EditText) findViewById(R.id.username);
        String txt_username = username.getText().toString();

        age = (EditText) findViewById(R.id.age);
        Integer txt_age = Integer.parseInt(age.getText().toString());

        outState.putString("txt_username",txt_username);
        outState.putInt("txt_age", txt_age);

        super.onSaveInstanceState(outState);
    }
}
