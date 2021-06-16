package com.example.customadapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.WeakHashMap;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Weather> data = null;
    private WeatherAdapter adapter = null;
    ListView list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data 넣어주기
        data = new ArrayList<Weather>();
        Weather weather = new Weather("월", R.drawable.w1, "맑음");
        data.add(weather);
        Weather weather1 = new Weather("월" ,R.drawable.w1,"맑음");
        Weather weather2 = new Weather("화", R.drawable.w2, "비");

        data.add(weather);
        data.add(new Weather("수",R.drawable.w3,"맑음 뒤 비"));


        adapter = new WeatherAdapter(MainActivity.this, R.layout.custom_layout, data);

        list = findViewById(R.id.list);
        list.setAdapter(adapter);


    }
}