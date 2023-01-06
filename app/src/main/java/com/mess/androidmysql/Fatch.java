package com.mess.androidmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Fatch extends AppCompatActivity {

    TextView name_txt, joindate_txt, email_txt, address_txt;
    private String strJson, apiUrl = "http://10.0.2.2/fatch.php";

    private OkHttpClient client;
    private Response response;
    private RequestBody requestBody;
    private Request request;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatch_data);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait.....");
        progressDialog.setCanceledOnTouchOutside(false);

        name_txt = findViewById(R.id.name_txt_id);
        joindate_txt = findViewById(R.id.joinDate_txt_id);
        email_txt = findViewById(R.id.eamil_txt_id);
        address_txt = findViewById(R.id.address_txt_id);

        progressDialog.show();
        client = new OkHttpClient();
        new GetUserDataRequest().execute();
    }
    public class GetUserDataRequest extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            request = new Request.Builder().url(apiUrl).build();
            try {
                response = client.newCall(request).execute();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            try {
                strJson = response.body().string();
                updateUserData(strJson);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void updateUserData(String strJson) {
        try {
            JSONArray parent = new JSONArray(strJson);
            JSONObject child =parent.getJSONObject(0);
            String name =child.getString("name");
            String joindate =child.getString("joinDate");
            String email =child.getString("email");
            String address =child.getString("address");

            name_txt.setText(name);
            joindate_txt.setText(joindate);
            email_txt.setText(email);
            address_txt.setText(address);
            progressDialog.hide();


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}