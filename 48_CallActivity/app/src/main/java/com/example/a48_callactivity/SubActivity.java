package com.example.a48_callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message","Sub onCreate");
        super.onCreate(savedInstanceState);

        //화면 회전
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //

        setContentView(R.layout.activity_sub);

        Button btnClose = findViewById(R.id.close);
        
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 나 다했다. 종료! 누르면 자기 빠지고 메인엑티비티 나옴
            }
        });
    }//onCreate

    @Override
    protected void onStart() {
        Log.v("Message","Sub onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message","Sub onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message"," Sub onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("Message","Sub onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message","Sub onDestroy");
        super.onDestroy();
    }
}