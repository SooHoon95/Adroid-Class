package com.example.a56_orderdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.call);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this, R.layout.order, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("주문 정보를 입력하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        .setView(linear)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText product = linear.findViewById(R.id.product);// 그냥 파인드 뷰 바이 아이디 하면 엑티비티.xml에서 불러오려한다. 당연히 안됨으로 리니어를 통해서 불러온다.
                                EditText number = linear.findViewById(R.id.number);
                                CheckBox paymethod = linear.findViewById(R.id.paymethod);
                                TextView textView = findViewById(R.id.text);
                                textView.setText("주문정보 : " + product.getText() + "상품, " + number.getText() + "개" + (paymethod.isChecked() ? "착불결재" : "")/*//if문 못 넣는다 삼항연산자 넣지.*/ );
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView textView = findViewById(R.id.text);
                                textView.setText("주문을 취소했습니다.");
                            }
                        })
                        .show();
            }
        });


    }
}