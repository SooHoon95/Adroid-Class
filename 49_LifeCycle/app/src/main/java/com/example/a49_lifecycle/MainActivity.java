package com.example.a49_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //내가 지금 라이프싸이클에서 어떤상태인지 알아보는 메소드
        Log.v("Message","onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }//onCreate

    @Override
    protected void onStart() {
        Log.v("Message", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message","onResume");
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.v("Message","onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("Message","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message","onDestroy");
        super.onDestroy();
    }
}//MainActivity