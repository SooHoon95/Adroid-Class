package com.example.a70_dbcrud.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a70_dbcrud.NetworkTask.NetworkTask;
import com.example.a70_dbcrud.R;

public class InsertActivity extends AppCompatActivity {

    String urlAddr = null; // url 받아온거 넘기는 과정;
    String scode, sname, sdept, sphone, macIP;
    EditText ecode , ename , ephone, edept;
    Button btnInsert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        // 나한테 뭔가 정보가 왔다. 받아야지.
        Intent intent = getIntent();
        // IP 주소가 날라왔네?
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/studentInsertReturn.jsp?";

        //xml 연결해주기.
        ecode = findViewById(R.id.insert_code);
        ename = findViewById(R.id.insert_name);
        edept = findViewById(R.id.insert_dept);
        ephone = findViewById(R.id.insert_phone);

        //입력시 자릿수 제한
        ecode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        ename.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        edept.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        ephone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});


        btnInsert = findViewById(R.id.insert_btn);
        btnInsert.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            scode = ecode.getText().toString();
            sname = ename.getText().toString();
            sdept = edept.getText().toString();
            sphone = ephone.getText().toString();

            //url완성해야함
            urlAddr = urlAddr + "code=" + scode + "&name=" + sname + "&dept=" + sdept + "&phone=" + sphone;

            String result = connectInsertData();
            if(result.equals("1")){
                // 정상인 경우 ( 1만 정상이라는 것은 jsp 에서 판단 할 수 있도록 만들 예정임. )
                Toast.makeText(InsertActivity.this, scode+"가 입력되었습니다", Toast.LENGTH_SHORT).show();
            }else /*에러걸렸으면*/ {
                Toast.makeText(InsertActivity.this, "입력이 실패되었습니다.",  Toast.LENGTH_SHORT).show();
            }
            // back 버튼을 누른 것과 동일한 역할 (= 입력 다했으니 메인으로 간다)
            finish(); // back 버튼으로 가느 것

        }
    };

    private String connectInsertData(){
        String result = null;
        try{
            NetworkTask networkTask = new NetworkTask(InsertActivity.this, urlAddr, "insert");
            Object obj = networkTask.execute().get();
            result = (String) obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}