package com.example.a43_listadddel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //데이터가 필요하니까
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<String>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, items);

        list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        list.setOnItemClickListener(mItemClickListener);
        findViewById(R.id.add).setOnClickListener(mClickListener);
        findViewById(R.id.del).setOnClickListener(mClickListener);


    }//onCreate

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText editText = findViewById(R.id.newItem);
            switch (v.getId()){
                case R.id.add:
                    String text = editText.getText().toString();
                    if(text.length() != 0){
                        items.add(text);
                        editText.setText("");
                        adapter.notifyDataSetChanged(); //************어레이리스트를 다시 읽어서 어뎁터를 새로 구성 그래야 새로 listView에 추가한걸 새로 보여줌
                    }
                    break;
                case R.id.del:
                    //id 값을 하나 만듬
                    int id;
                    id = list.getCheckedItemPosition(); //몇번째 체크했는지 가져온다.
                    if(id != ListView.INVALID_POSITION){
                        items.remove(id);
                        list.clearChoices();    // 이거를 해주면 중간에 item 지웠을때 초이스가 전부 다 초기화 된다. 안그러면 계속 지워짐
                        adapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };



    //longClickListener도 있는데 이거는 길게 눌렀을때 실행하는 이벤트
    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String message;
              message = "Select Item = " + items.get(position);
              Toast.makeText(MainActivity.this, message,Toast.LENGTH_SHORT).show();
        }
    };



}//MainActivity