package com.example.anhlk.project1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AnhLK on 7/12/2016.
 */
public class ChangePwdActivity extends Activity implements View.OnClickListener {
    Button btn_back;
    EditText edt_old_pwd;
    EditText edt_new_pwd;
    EditText edt_confirm_pwd;
    Button btn_change_pwd;
    String old_pwd;
    String new_pwd;
    String confirm_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        btn_back = (Button) findViewById(R.id.btn_back);
        if(btn_back!=null){
            btn_back.setOnClickListener(this);
        }
        edt_old_pwd = (EditText) findViewById(R.id.edt_old_pwd);
        edt_new_pwd = (EditText) findViewById(R.id.edt_new_pwd);
        edt_confirm_pwd = (EditText) findViewById(R.id.edt_confirm_pwd);
        btn_change_pwd = (Button) findViewById(R.id.btn_change_pwd);
        if(btn_change_pwd!=null){
            btn_change_pwd.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_change_pwd:
            break;
        }
    }
}
