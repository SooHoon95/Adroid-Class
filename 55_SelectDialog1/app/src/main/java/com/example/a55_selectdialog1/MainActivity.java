package com.example.a55_selectdialog1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mSelect = 0 ;
    boolean[]  mSelectMulti = {false, false, false, false};// 초기값을 아무것도 체크안한걸로 줌

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.call);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("음식을 선택하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMultiChoiceItems(R.array.foods, mSelectMulti,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        mSelectMulti[which] = isChecked;
                                    }
                                }
                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //데이터 넣어주는 작업
                                String[] foods = getResources().getStringArray(R.array.foods);
                                TextView textView = findViewById(R.id.text);

                                String result = "선택한 음식" ;
                                for(int i=0; i < mSelectMulti.length; i++){
                                    if (mSelectMulti[i]){
                                        result += foods[i] + " / ";
                                    }
                                }
                                textView.setText(result);
                            }
                        })
                        .setNegativeButton("취소",null)
                        .show();
            }
        });
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("음식을 선택하세요")
//                        .setIcon(R.mipmap.ic_launcher)
//                        .setSingleChoiceItems(R.array.foods, mSelect,
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        mSelect = which;
//                                    }
//                                }
//                        )
//                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                TextView textView = findViewById(R.id.text);
//                                textView.setText("선택한 음식 : " + foods[which]);
//                            }
//                        })//setItems
//                        .setNegativeButton("취소", null)
//                        .show();
//            }
//        });








//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("음식을 선택하세요")
//                        .setIcon(R.mipmap.ic_launcher)
//                        .setItems(R.array.foods,
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        String[] foods = getResources().getStringArray(R.array.foods);
//                                        TextView textView = findViewById(R.id.text);
//                                        textView.setText("선택한 음식 : " + foods[which]);
//                                    }
//                                }
//                        )
//                        .setCancelable(false)
//                        .setNegativeButton("취소", null)
//                        .show();
//            }
//        });


    }
}