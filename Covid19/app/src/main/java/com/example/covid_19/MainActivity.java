package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

  //DECLARE PROPERTIES
  Spinner spinner;
  ImageView flagImages;
  CountryData countryData;
  Button statisticsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INIZIALIZE PROPERTIES
        spinner=(Spinner) findViewById(R.id.myspinner);
        flagImages =(ImageView) findViewById(R.id.flagimages);
        statisticsBtn= (Button) findViewById(R.id.statisticsbtn);
        countryData = new CountryData();


        // SET ADAPTER FOR THE SPINNER AND PASS DATA TO IT
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,countryData.countryNames));
          //SET onItemSelected FOR THE SPINNER TO TAKE ACTION WHEN SOME ITEM IN THE SPINNER IS SELECTED
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //LOOP TROUGH THE FLAGES AND SET THE CURRENT SELECTED COUNTRY POSITON FOR IT
                flagImages.setImageResource(countryData.countryFlages[spinner.getSelectedItemPosition()]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //SET ONCLICKLISTENER FOR STATISTICS BUTTON TO OPEN NEW ACTIVITY
        statisticsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Statistics.class);
                startActivity(intent);
            }
        });
    }
}