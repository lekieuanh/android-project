package com.example.anhlk.project1;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_email;
    EditText edt_password;
    Button btn_login;
    Button btn_forgot;
    Button btn_back;
    String email;
    String password;
    AlertDialog mAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ActionBar mActionBar = getSupportActionBar();
//        mActionBar.setDisplayShowHomeEnabled(false);
//        mActionBar.setDisplayShowTitleEnabled(false);
//
//        LayoutInflater mInflater = LayoutInflater.from(this);
//
//        View mCustomView = mInflater.inflate(R.layout.actionbar_layout, null);
//        ImageView imageView1 = (ImageView) mCustomView.findViewById(R.id.btn_back);
//        TextView textView = (TextView) mCustomView.findViewById(R.id.andG);
//        ImageView imageView2 = (ImageView) mCustomView.findViewById(R.id.btn_forgot);
//
//        mActionBar.setCustomView(mCustomView);
//        mActionBar.setDisplayShowCustomEnabled(true);
//
//        Toolbar toolbar = (Toolbar) mCustomView.getParent();
//        toolbar.setContentInsetsAbsolute(0, 0);
//        toolbar.getContentInsetEnd();
//        toolbar.setPadding(0, 0, 0, 0);
        btn_forgot = (Button) findViewById(R.id.btn_forgot);
        if (btn_forgot != null) {
            btn_forgot.setOnClickListener(this);
        }
        btn_login = (Button) findViewById(R.id.btn_login);
        if (btn_login != null) {
            btn_login.setOnClickListener(this);
        }
        btn_back = (Button) findViewById(R.id.btn_back);
        if (btn_back != null) {
            btn_back.setOnClickListener(this);
        }

        edt_email = (EditText) findViewById(R.id.txt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);
        mAlertDialog = new AlertDialog.Builder(this)
                .setTitle("Incorrect email or password")
                .setMessage("Make sure your email and password are both correct.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                email = edt_email.getText().toString();
                password = edt_password.getText().toString();

                if (("anh@gmail.com").equals(email) && ("abc").equals(password)) {
                    Intent intent = new Intent(this, RecentReportActivity.class);
                    startActivity(intent);
                } else {
                    mAlertDialog.show();
                }
                break;
            case R.id.btn_forgot:
                Intent intent = new Intent(this, ChangePwdActivity.class);
                startActivity(intent);
                break;
            case  R.id.btn_back:
                finish();
                break;
        }
    }
}
