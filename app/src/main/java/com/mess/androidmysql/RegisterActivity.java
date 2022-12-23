package com.mess.androidmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
EditText username1,useremail1,userdepartment1,usercontract1;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username1 = (EditText)findViewById(R.id.username);
        useremail1 = (EditText)findViewById(R.id.useremal);
        userdepartment1 = (EditText)findViewById(R.id.userdepartment);
        usercontract1 = (EditText)findViewById(R.id.usercontract);
        submit = (Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username1.getText().toString();
                String useremail = useremail1.getText().toString();
                String userdepartment = userdepartment1.getText().toString();
                String usercontract = usercontract1.getText().toString();
                String type = "register";
                backgroundworker backgroundworker = new backgroundworker(RegisterActivity.this);
                backgroundworker.execute(type,username,useremail,userdepartment,usercontract);
            }
        });

    }
}