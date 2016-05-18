package com.example.karmolrut.drugnotification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by karmolrut on 6/5/2559.
 */
public class  manual extends AppCompatActivity {
    ImageButton btnn1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual);
        btnn1 = (ImageButton) findViewById(R.id.imageButton);

        btnn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                donoti1();

            }
        });
        final ImageButton btnn2 = (ImageButton) findViewById(R.id.imageButton2);
        // Perform action on click
        btnn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dosearch();

            }
        });

    }


    public void dosearch() {
        setContentView(R.layout.dosearch);

    }



    public void donoti1() {
        setContentView(R.layout.donoti1);
        final Button donoti1 = (Button) findViewById(R.id.button4);
        donoti1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                donoti2();
            }
        });
    }
    public void donoti2() {
        setContentView(R.layout.donoti2);
        final Button donoti21 = (Button) findViewById(R.id.button7);
        donoti21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                donoti1();
            }
        });

        final Button donoti22 = (Button) findViewById(R.id.button5);
        donoti22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                donoti3();
            }
        });
    }



    public void donoti3() {
        setContentView(R.layout.donoti3);

        final Button donoti31 = (Button) findViewById(R.id.button8);
        donoti31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                donoti2();
            }
        });

        final Button donoti32 = (Button) findViewById(R.id.button9);
        donoti32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                donoti4();
            }
        });

    }





    public void donoti4() {
        setContentView(R.layout.donoti4);
        final Button donoti4 = (Button) findViewById(R.id.button10);
        donoti4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                donoti3();
            }
        });
    }
    public void onBackPressed() {
        Intent homepage = new Intent(manual.this, home.class);
        startActivity(homepage);
    }
}
