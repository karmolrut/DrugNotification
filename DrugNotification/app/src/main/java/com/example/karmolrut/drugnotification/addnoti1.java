package com.example.karmolrut.drugnotification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Created by karmolrut on 6/5/2559.
 */
public class addnoti1 extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnoti1);

        final Button addnoti1 = (Button) findViewById(R.id.addnoti11);
        addnoti1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent homepage = new Intent(addnoti1.this, addnoti.class);
                startActivity(homepage);

            }
        });
        addnotii();
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void addnotii() {


        final ListView lisView2 = (ListView) findViewById(R.id.listView2);


        // bt11 = (Button) findViewById(R.id.button11);


        String url = "http://activityen.azurewebsites.net/drugnotification/boxlist2.php";


        // Paste Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("txtKeyword", "mmm"));
        //params.add(new BasicNameValuePair("time", "jjj"));

        System.currentTimeMillis();

        Calendar clock = Calendar.getInstance();

        SimpleDateFormat format1;
        format1 = new SimpleDateFormat("HH");
        String time = format1.format(clock.getTime()) + "";
        int realtime = Integer.parseInt(time);

        Calendar minn = Calendar.getInstance();

        SimpleDateFormat format2;
        format2 = new SimpleDateFormat("mm");
        String minni = format2.format(minn.getTime()) + "";
        int mint = Integer.parseInt(minni);


        String sum;
        sum = (realtime + "" + mint);
        int summ;
        summ = Integer.parseInt(sum);

        Calendar day = Calendar.getInstance();
        SimpleDateFormat format3;
        format3 = new SimpleDateFormat("dd");
        String dayy = format3.format(day.getTime()) + "";
        int daydate = Integer.parseInt(dayy);


        Calendar mount = Calendar.getInstance();
        SimpleDateFormat format4;
        format4 = new SimpleDateFormat("MM");
        String mountt = format4.format(mount.getTime()) + "";
        int mountdate = Integer.parseInt(mountt);

        Calendar year = Calendar.getInstance();
        SimpleDateFormat format5;
        format5 = new SimpleDateFormat("yyyy");
        String yearr = format5.format(year.getTime()) + "";
        int yeardate = Integer.parseInt(yearr);

        String dmy;
        dmy = (daydate + "" + mountdate + "" + (yeardate + 543));
        int daymy;
        daymy = Integer.parseInt(dmy);


        try {
            JSONArray data = new JSONArray(getJSONUrl(url, params));

            final ArrayList<HashMap<String, String>> addlist2 = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;


            String[] hourmin = new String[data.length()];
            int[] hour_min = new int[data.length()];


            String[] datem = new String[data.length()];
            int[] date_dmy = new int[data.length()];

            String[] timea = new String[data.length()];
            int[] timee = new int[data.length()];


            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);

                map = new HashMap<String, String>();
                map.put("CustomerID", c.getString("Drug_name") + " " + c.getString("Drug_amount") + " " + c.getString("Drug_type") + "\n" + "เวลา " + c.getString("time_hour") + ":" + c.getString("time_min") + " น. " + "\n" + c.getString("day") + "/" + c.getString("mount") + "/" + c.getString("year") + " ถึง " + c.getString("time") + "/" + c.getString("mount2") + "/" + c.getString("yearr"));

                addlist2.add(map);

                timea[i] = c.getString("time") + c.getString("mount2") + c.getString("yearr");
                timee[i] = Integer.parseInt(timea[i]);

                hourmin[i] = c.getString("time_hour") + c.getString("time_min");
                hour_min[i] = Integer.parseInt(hourmin[i]);


                datem[i] = c.getString("day") + c.getString("mount") + c.getString("year");
                date_dmy[i] = Integer.parseInt(datem[i]);


                Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


                final NotificationManager mNM = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                Intent intent1 = new Intent(this.getApplicationContext(), MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);
                Notification mNotification = new Notification.Builder(this)

                        .setContentTitle(c.getString("Drug_name") + " " + c.getString("Drug_amount") + " " + c.getString("Drug_type"))    //ให้โชว์ชื่อยา จำนวน ขนาด
                        .setContentText(c.getString("message_warn"))
                        .setSmallIcon(R.drawable.iconapp)
                        .setSound(soundUri)
                        .setContentIntent(pIntent)
                        .setAutoCancel(true)
                        .build();

                if (summ == hour_min[i]) {   //sum เวลาในเครื่อง  hourmin เวลา
                    if (daymy == date_dmy[i]) {  //daymy วันที่เดือนพศในเครื่อง  date_dmy วันที่เดือนพศในดาต้าเบส

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        mNotification.flags |= Notification.FLAG_AUTO_CANCEL;
                        notificationManager.notify(0, mNotification);

                    } else if (date_dmy[i] < timee[i] && daymy >= date_dmy[i] && daymy <= timee[i]) {

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, mNotification);
                    }


                }


            }


            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(addnoti1.this, addlist2, R.layout.activity_column,
                    new String[]{"CustomerID"}, new int[]{R.id.ColCustomerID});
            lisView2.setAdapter(sAdap);


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public String getJSONUrl(String url, List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Download OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download file..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public void onBackPressed() {
        Intent homepage = new Intent(addnoti1.this, home.class);
        startActivity(homepage);
    }
}

