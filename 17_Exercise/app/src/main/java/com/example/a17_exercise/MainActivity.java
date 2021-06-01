package com.example.a17_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    LinearLayout F1;
    LinearLayout F2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        F1 = findViewById(R.id.F1);
        F2 = findViewById(R.id.F2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                F1.setVisibility(v.VISIBLE);
                F2.setVisibility(v.INVISIBLE);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                F1.setVisibility(v.INVISIBLE);
                F2.setVisibility(v.VISIBLE);
            }
        });

    }
}

