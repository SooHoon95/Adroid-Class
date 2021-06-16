package com.example.a65_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/* 세팅작업
    1. Network 세팅 >> 메니페스트
    2. 리스트뷰에 필요한 작업 어레이, 빈
    3. 어뎁터 필요 리스트 뷰에 넣을거니까
    4. Json parsind 제이슨 자르는거
 */

public class MainActivity extends AppCompatActivity {

    String urlAddr = "http://192.168.0.3:8080/test/students.json";
    Button button;
    ListView listView;
    ArrayList<StudentsInfo> students;
    StudentsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_network_con);
        listView = findViewById(R.id.lv_members);

        button.setOnClickListener(onClickListener);

        Log.v("test", "start");
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_network_con:
                    try{
                        NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
                        Object obj = networkTask.execute().get();
                        students = (ArrayList<StudentsInfo>) obj;
                        // 데이터 가져옴

                        //화면에 띄우기
                        adapter = new StudentsAdapter(MainActivity.this, R.layout.custom_layout, students);
                        listView.setAdapter(adapter);
                        button.setText("Result");

                    }catch (Exception e){

                    }

            }
        }
    };


}//================