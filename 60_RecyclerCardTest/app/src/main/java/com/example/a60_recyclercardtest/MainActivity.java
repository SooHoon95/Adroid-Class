package com.example.a60_recyclercardtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //만들고 형성했던 카드뷰를 어떤 레이아웃으로 보여줄건지 정해야하니까
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_View);

        // 레이아웃 메니져 사용할건데 아까 사진에서 보여줬던 세개중에하나 쓸거임
//        layoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(this, 2);
//        layoutManager= new StaggeredGridLayoutManager(this,)
        recyclerView.setLayoutManager(layoutManager);

        //어뎁터 연결
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);





    }
}