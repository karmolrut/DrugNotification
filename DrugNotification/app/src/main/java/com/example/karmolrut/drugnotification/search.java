package com.example.karmolrut.drugnotification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karmolrut on 6/5/2559.
 */
public class search extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);


        final TextView view = (TextView) findViewById(R.id.textView2);
        final Button bt = (Button) findViewById(R.id.button);

        final AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        acTextView.setThreshold(1);
        acTextView.setAdapter(new SuggestionAdapter(this, acTextView.getText().toString()));


        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "http://activityen.azurewebsites.net/drugnotification/search.php";
                List<NameValuePair> params = new ArrayList<NameValuePair>();

                params.add(new BasicNameValuePair("strUser", acTextView.getText().toString()));

                String resultServer = getHttpPost(url, params);

                /*** Default Value ***/
                String strStatusID = "";
                String name = "";
                String com = "";
                String types = "";
                String prop = "";
                String inst = "";
                String side = "";
                String sto = "";
                String pic = "";

                JSONObject c;
                try {
                    c = new JSONObject(resultServer);
                    strStatusID = c.getString("StatusID");
                    name = c.getString("name");
                    com = c.getString("com");
                    types = c.getString("types");
                    prop = c.getString("prop");
                    inst = c.getString("inst");
                    side = c.getString("side");
                    sto = c.getString("sto");
                    pic = c.getString("pic");


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (strStatusID.equals("1"))
                    view.setText("ชื่อทางการค้า : " + name + "\n\nชื่อสามัญ : " + com + "\n\nรูปแบบ : " + types + "\n\nสรรพคุณ : " + prop + "\n\nขนาดและวิธีใช้ : " + inst + "\n\nอาการข้างเคียง : " + side + "\n\nวิธีเก็บรักษา : " + sto + "\n\n" + pic);

                else
                    view.setText(name + "\n" + prop + "\n" + inst + "\n" + side);

            }
        });

    }

    public String getHttpPost(String url, List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Status OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
    public void onBackPressed() {
        Intent homepage = new Intent(search.this, home.class);
        startActivity(homepage);
    }
}
