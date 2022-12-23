package com.mess.androidmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
EditText newname,newdepartment,newcontract,newemail;
Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        newname = (EditText)findViewById(R.id.newname);
        newdepartment = (EditText)findViewById(R.id.newdepartment);
        newcontract = (EditText)findViewById(R.id.newcontract);
        newemail = (EditText)findViewById(R.id.newmail);
        update = (Button)findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String N_name = newname.getText().toString();
                String N_department = newdepartment.getText().toString();
                String  N_contract = newcontract.getText().toString();
                String  Match_email = newemail.getText().toString();
                String type = "update";
                backgroundworker backgroundworker = new backgroundworker(UpdateActivity.this);
                backgroundworker.execute(type,N_name,N_department,N_contract,Match_email);
            }
        });
    }
}