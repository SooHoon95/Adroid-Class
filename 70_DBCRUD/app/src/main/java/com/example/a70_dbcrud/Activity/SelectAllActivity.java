package com.example.a70_dbcrud.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a70_dbcrud.Adapter.StudentAdapter;
import com.example.a70_dbcrud.Bean.Student;
import com.example.a70_dbcrud.NetworkTask.NetworkTask;
import com.example.a70_dbcrud.R;

import java.util.ArrayList;

public class SelectAllActivity extends AppCompatActivity {

    String urlAddr = null;
    ArrayList<Student> members;
    StudentAdapter adapter;
    ListView listView;
    String macIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);

        listView = findViewById(R.id.lv_student);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/student_query_all.jsp";
        Log.v("AA","2");
    }

    @Override
    protected void onResume() { // 이 리슘에 데이터 부르는게 들어간다.
        super.onResume();
        connectGetData(); //*******************
    }

    private void connectGetData(){
        try{
            NetworkTask networkTask = new NetworkTask(SelectAllActivity.this, urlAddr, "select");
            Object obj = networkTask.execute().get();
            members = (ArrayList<Student>) obj;
            Log.v("AA","test123");
            Log.v("AA",members.get(1).toString());
            adapter = new StudentAdapter(SelectAllActivity.this, R.layout.student_layout, members);
            Log.v("AA","Test");
            listView.setAdapter(adapter);

//            listView.setOnItemClickListener(onItemClickListener);
//            listView.setOnItemLongClickListener(onItemLongClickListener);


            Log.v("AA","3333");
        }catch (Exception e){
            e.printStackTrace();
            Log.v("AA","Error 1111");
        }
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        Intent intent = null;
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
            intent.putExtra("code",members.get(position).getCode());
            intent.putExtra("name",members.get(position).getName());
            intent.putExtra("dept",members.get(position).getDept());
            intent.putExtra("phone",members.get(position).getPhone());

            //ip address를 넘겨준다.
            intent.putExtra("macIP",macIP);
            startActivity(intent);
        }
    };

    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
       Intent intent = null;
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
            intent.putExtra("code",members.get(position).getCode());
            intent.putExtra("name",members.get(position).getName());
            intent.putExtra("dept",members.get(position).getDept());
            intent.putExtra("phone",members.get(position).getPhone());

            //ip address를 넘겨준다.
            intent.putExtra("macIP",macIP);
            startActivity(intent);
            return false;
        }

    };


}