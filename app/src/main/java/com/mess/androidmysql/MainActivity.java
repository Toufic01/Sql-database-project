package com.mess.androidmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText name,email;
Button submit,next,update,delect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        submit = (Button)findViewById(R.id.submit);
        next = (Button)findViewById(R.id.next);
        update = (Button)findViewById(R.id.update);
        delect = (Button)findViewById(R.id.delect);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String useremail = email.getText().toString();
                String type = "login";
                backgroundworker backgroundworker = new backgroundworker(MainActivity.this);
                backgroundworker.execute(type,username,useremail);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Fatch.class));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UpdateActivity.class));
            }
        });

        delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DelectActivity.class));
            }
        });
    }
}