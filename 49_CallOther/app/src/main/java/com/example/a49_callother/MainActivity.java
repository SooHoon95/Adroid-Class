package com.example.a49_callother;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.web).setOnClickListener(mClickListener);
        findViewById(R.id.dial).setOnClickListener(mClickListener);
        findViewById(R.id.list).setOnClickListener(mClickListener);

    }//onCreate

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           //인텐트 하나 생성
            Intent intent;

            switch (v.getId()){
                case R.id.web:
                    //명시적 인텐트.
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:///www.google.com"));
                    startActivity(intent);
                    break;
                case R.id.dial:
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
                    startActivity(intent);
                    break;
                case R.id.list:
                    intent = new Intent(Intent.ACTION_MAIN);
                    intent.setComponent(new ComponentName("com.example.a43_listadddel", "com.example.a43_listadddel.MainActivity"));   //본인들이 개발한게 아니면 쓸 수 없다.
                    startActivity(intent);
                    break;
            }
        }
    };

}