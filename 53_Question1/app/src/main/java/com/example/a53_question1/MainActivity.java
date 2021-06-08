package com.example.a53_question1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a = 3;
    int b = 4;
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.call);

        button.setOnClickListener(new View.OnClickListener() { //Button.Oncl== 해도 된다.
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("어떤 연산을 하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("덧셈", mClick)
                        .setNegativeButton("곱셈", mClick)
                        .show();
            }
        });


    }//onCreate

    DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() { //다이얼로그에 액션하는 리스너니까 OnClickList 선택할때 다이얼로그 거 선택한다.
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //다이얼로그는 id값이 없기때문에 getId 쓸 수 없다.
            if(which == DialogInterface.BUTTON_POSITIVE){
                result = a+b;
            }else{
                result=a*b;
            }
            TextView textView = findViewById(R.id.result);
            textView.setText("연산결과 : " + result);
            Toast.makeText(MainActivity.this,"연산을 완료했습니다.", Toast.LENGTH_SHORT).show();
        }
    };


}