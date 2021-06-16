package com.example.a64_networkjson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* 세팅작업
    1. Network 세팅 >> 메니페스트
    2. 리스트뷰에 필요한 작업 어레이, 빈
    3. 어뎁터 필요 리스트 뷰에 넣을거니까
    4. Json parsind 제이슨 자르는거
 */
public class MainActivity extends AppCompatActivity {

    String urlAddr = "http://192.168.2.11:8080/test/json_members.json";
    Button button;
    ListView listView;
    ArrayList<JsonMember> members;
    MemberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_network_con);
        listView = findViewById(R.id.lv_members);

        button.setOnClickListener(onClickListener);

        Log.v("Message","test1");
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                  switch (v.getId()){
                      case R.id.btn_network_con:
                          Log.v("Message" ,"test2");
                          try{
                              NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
                              // 이부분 무슨 뜻임? 걍 오브젝트로 바꿔서 가져온다는 뜻인듯
                              Object obj = networkTask.execute().get();
                              members = (ArrayList<JsonMember>) obj;
                              //여기까지 데이터 가져온거다.

                              //이제 화면에 띄우기 위해서 어뎁터 연결하기
                              adapter = new MemberAdapter(MainActivity.this, R.layout.custom_layout, members);
                              listView.setAdapter(adapter);
                              button.setText("Results");

                              Log.v("Message","onClickListener 끝");
                          }catch (Exception e){
                            e.printStackTrace();
                          }
                  }
        }
    };


}//-===============