package com.mess.androidmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DelectActivity extends AppCompatActivity {
EditText dept_name;
Button delect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delect);

        dept_name = (EditText)findViewById(R.id.delect_dept);
        delect = (Button) findViewById(R.id.delect);

        delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String delect_dept_name = dept_name.getText().toString();
                String type = "delect";
                backgroundworker backgroundworker = new backgroundworker(DelectActivity.this);
                backgroundworker.execute(type,delect_dept_name);
            }
        });
    }
}