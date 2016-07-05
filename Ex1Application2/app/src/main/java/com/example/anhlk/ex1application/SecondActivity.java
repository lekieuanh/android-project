package com.example.anhlk.ex1application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by AnhLK on 6/29/2016.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent = getIntent();
        Toast.makeText(this,intent.getStringExtra("username")+ " is "+intent.getIntExtra("age",0) + " years old",Toast.LENGTH_SHORT).show();
    }
    public void onClick1(View view){
        EditText txtgettext = (EditText) findViewById(R.id.txt_gettext);

        Intent intent = new Intent();
        Bundle extra = new Bundle();
        extra.putString("str",txtgettext.getText().toString());
        intent.putExtras(extra);
        setResult(RESULT_OK,intent);
        finish();
    }
}
