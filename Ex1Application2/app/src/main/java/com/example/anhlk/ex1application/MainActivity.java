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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        EditText username = (EditText) findViewById(R.id.username);
        EditText age = (EditText) findViewById(R.id.age);

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
}
