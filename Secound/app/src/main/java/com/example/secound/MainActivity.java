package com.example.secound;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnRed1;
    Button btnGreen1;
    Button btnBlue1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRed1 = findViewById(R.id.btnRed);  //R은 리소스 즉 xml이라는 뜻
        btnGreen1 = findViewById(R.id.btnGreen);
        btnBlue1 = findViewById(R.id.btnBlue);

        //강사님 방법
        btnRed1.setOnClickListener(onClickListener);
        btnGreen1.setOnClickListener(onClickListener);
        btnBlue1.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            String colorString = "";

            switch (v.getId()) {//v=view
                case R.id.btnRed:
                    colorString = "빨간색";
                    break;
                case R.id.btnGreen:
                    colorString = "초록색";
                    break;
                case R.id.btnBlue:
                    colorString = "파란색";
                    break;
            }
            Toast.makeText(MainActivity.this, colorString + "버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
        }
    };
}



            //내방법
//        buttonGreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"초록색버튼을 눌렀습니다!", Toast.LENGTH_SHORT).show();
//                //context : 위치 , 상태
//                //text: 띄울 텍스트
//                //duration: 메시지를 표시하는 시간
//                    //LENGTH_SHORT : 약 2초
//
//            }
//        }) ;
//
//        buttonRed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "빨간색버튼을 눌렀습니다!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        buttonBlue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "파란색버튼을 눌렀습니다!", Toast.LENGTH_SHORT).show();
//            }
//        });

//
//        }
//    }
//}