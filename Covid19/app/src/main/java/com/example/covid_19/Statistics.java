package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Statistics extends AppCompatActivity {

    ImageView backIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //INIZIALIZE PROPERTIES
        backIcon = (ImageView) findViewById(R.id.backicon);

        //Add Click Listener for the back-icon so that it can open the Mainactivity
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Statistics.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}