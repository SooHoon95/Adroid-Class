package com.example.a38_customadapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.nio.file.Watchable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Weather> data = null;
    private WeatherAdapter adapter = null;
    private ListView listView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data 만들기
        data = new ArrayList<Weather>();
        data.add(new Weather("월", R.drawable.w1, "맑음") );
        data.add(new Weather("화", R.drawable.w2, "비") );
        data.add(new Weather("수", R.drawable.w3, "맑음 뒤 비") );
        data.add(new Weather("목", R.drawable.w4, "추움") );
        data.add(new Weather("금", R.drawable.w5, "안개") );
        data.add(new Weather("토", R.drawable.w6, "눈") );
        data.add(new Weather("일", R.drawable.w7, "우박") );
        data.add(new Weather("월", R.drawable.w1, "맑음") );
        data.add(new Weather("화", R.drawable.w2, "비") );
        data.add(new Weather("수", R.drawable.w3, "맑음 뒤 비") );
        data.add(new Weather("목", R.drawable.w4, "추움") );
        data.add(new Weather("금", R.drawable.w5, "안개") );
        data.add(new Weather("토", R.drawable.w6, "눈") );
        data.add(new Weather("일", R.drawable.w7, "우박") );

        //Adapter 연결
        adapter = new WeatherAdapter(MainActivity.this, R.layout.custom_layout, data);

        //ListView 연결
        listView = findViewById(R.id.lv_weather);
        listView.setAdapter(adapter);

    }
}