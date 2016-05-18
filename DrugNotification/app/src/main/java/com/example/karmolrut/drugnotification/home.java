package com.example.karmolrut.drugnotification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by karmolrut on 6/5/2559.
 */
public class home extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        final ImageButton btn1 = (ImageButton) findViewById(R.id.button1);
        // Perform action on click
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homepage = new Intent(home.this, addnoti1.class);
                startActivity(homepage);
            }
        });
        final ImageButton btn2 = (ImageButton) findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homepage = new Intent(home.this, search.class);
                startActivity(homepage);
            }
        });

        final ImageButton btn3 = (ImageButton) findViewById(R.id.button3);
        // Perform action on click
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homepage = new Intent(home.this,manual.class);
                startActivity(homepage);

            }
        });
    }

    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
