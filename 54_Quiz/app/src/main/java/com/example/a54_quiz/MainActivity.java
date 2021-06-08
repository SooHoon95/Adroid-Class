package com.example.a54_quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int a ;
    int b ;
    int result;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.dalog);
        textView = findViewById(R.id.tv1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("좌변을 선택하십시오")
                        .setCancelable(false)
                        .setPositiveButton("3",mClick)
                        .setNegativeButton(" 4",mClick)
                        .show();
            }
        });
    }//onCreate


    DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE) {
                a=3;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문2")
                        .setMessage("우변을 선택하십시오")
                        .setCancelable(false)
                        .setPositiveButton("5", nClick)
                        .setNegativeButton("6", nClick)
                        .show();
            }else if(which == DialogInterface.BUTTON_NEGATIVE){
                a=4;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문2")
                        .setMessage("우변을 선택하십시오")
                        .setCancelable(false)
                        .setPositiveButton("5", nClick)
                        .setNegativeButton("6", nClick)
                        .show();
            }
        }
    };


    DialogInterface.OnClickListener nClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                b=5;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문3")
                        .setMessage("어떤연산을 하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("덧셈", zClick)
                        .setNegativeButton("곱셈", zClick)
                        .show();
            }else{
                b=6;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문3")
                        .setMessage("어떤연산을 하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("덧셈", zClick)
                        .setNegativeButton("곱셈", zClick)
                        .show();
            }
        }
    };

    DialogInterface.OnClickListener zClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                result = a + b;
                textView.setText("연산결과  : " + result);
            }else{
                result = a * b;
                textView.setText("연산결과  : " + result);
            }
        }
    };




}