package com.example.a48_callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message","Main onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall = findViewById(R.id.call);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });


    }//onCreate

    @Override
    protected void onStart() {
        Log.v("Message","Main onStart" );
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.v("Message","Main onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message","Main onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("Message","Main onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message","Main onDestroy");
        super.onDestroy();
    }
}