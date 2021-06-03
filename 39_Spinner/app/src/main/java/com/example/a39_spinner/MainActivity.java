package com.example.a39_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> adapter = null;
    Spinner spinner = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = ArrayAdapter.createFromResource(this,R.array.travelArea,
                /*레이아웃*/ android.R.layout.simple_spinner_dropdown_item);


        spinner = findViewById(R.id.sp_01);
        spinner.setAdapter(adapter);


    }
}