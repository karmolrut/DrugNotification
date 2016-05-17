package com.example.karmolrut.drugnotification;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Calendar;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by karmolrut on 6/5/2559.
 */
public class addnoti extends Activity implements View.OnClickListener {
    String drugn, drugt, druga, day, mount, year, th, tm, ms, dmta, mou, yearr;
    Button galery, sound, savenoti, bt11;
    EditText drugname, drugtype, drugamount, messa, selecttimeh, selecttimem, dayy, mountt, years, dtma, moun, year_s;

    int s;

    private int mHour;
    private int mMinute;

    private int mYear;
    private int mMonth;
    private int mDay;
    OkHttpClient okHttpClient = new OkHttpClient();
    String State;

    static final int DATE_DIALOG_ID = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnoti);


        selecttimeh = (EditText) findViewById(R.id.editText5);
        selecttimem = (EditText) findViewById(R.id.editText4);
        dayy = (EditText) findViewById(R.id.editText6);
        mountt = (EditText) findViewById(R.id.editText8);
        years = (EditText) findViewById(R.id.editText9);
        dtma = (EditText) findViewById(R.id.editText10);
        moun = (EditText) findViewById(R.id.editText11);
        year_s = (EditText) findViewById(R.id.editText12);
        savenoti = (Button) findViewById(R.id.button6);

        drugname = (EditText) findViewById(R.id.editText);
        drugtype = (EditText) findViewById(R.id.editText2);
        drugamount = (EditText) findViewById(R.id.editText3);
        messa = (EditText) findViewById(R.id.editText7);


        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR);
        mMinute = c.get(Calendar.MINUTE);

        // get the current date

        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        savenoti.setOnClickListener(this);



                //  String url = "http://activityen.azurewebsites.net/drugnotification/addnoti.php";
            }


    public void onClick(View v) {
        drugn = drugname.getText().toString().trim();
        drugt = drugtype.getText().toString().trim();
        druga = drugamount.getText().toString().trim();
        day = dayy.getText().toString().trim();
        mount = mountt.getText().toString().trim();
        year = years.getText().toString().trim();
        th = selecttimeh.getText().toString().trim();
        tm = selecttimem.getText().toString().trim();
        ms = messa.getText().toString().trim();
        dmta = dtma.getText().toString().trim();
        mou = moun.getText().toString().trim();
        yearr = year_s.getText().toString().trim();

        AsyncTaskGetData asyncTaskGetData = new AsyncTaskGetData();
        asyncTaskGetData.execute("1", drugn, drugt, druga, day, mount, year, th, tm, ms, dmta, mou, yearr);

        Intent homepage = new Intent(addnoti.this, addnoti1.class);
        startActivity(homepage);
    }

        public class AsyncTaskGetData extends AsyncTask<String, Void, Void> {

            @Override
            protected void onPostExecute(Void aVoid) {
            }

            @Override
            protected Void doInBackground(String... params) {

                // Initialize Builder (not RequestBody)

                FormBody.Builder builder = new FormBody.Builder();
                // Add Params to Builder
                builder.add("sID", params[0]);
                builder.add("drugn", params[1]);
                builder.add("drugt", params[2]);
                builder.add("druga", params[3]);
                builder.add("day", params[4]);
                builder.add("mount", params[5]);
                builder.add("year", params[6]);
                builder.add("th", params[7]);
                builder.add("tm", params[8]);
                builder.add("ms", params[9]);
                builder.add("dmta", params[10]);
                builder.add("mou", params[11]);
                builder.add("yearr", params[12]);


                RequestBody body = builder.build();


                Request request = new Request.Builder().url("http://activityen.azurewebsites.net/drugnotification/addnoti.php").post(body).build();
                Response response;

                try {
                    response = okHttpClient.newCall(request).execute();
                    String result = response.body().string();

                    JSONObject jsonObject;

                    try {

                        jsonObject = new JSONObject(result);

                        // Query JSON tag: State
                        State = jsonObject.getString("State");
                        System.out.println(State);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {

                    e.printStackTrace();
                }
                return null;
            }
        }

    public void onBackPressed() {
        Intent homepage = new Intent(addnoti.this, addnoti1.class);
        startActivity(homepage);
    }

    }



