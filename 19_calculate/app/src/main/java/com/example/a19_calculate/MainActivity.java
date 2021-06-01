package com.example.a19_calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    Button btnPlus, btnMinus, btnMulti, btnShare;
    EditText input1, input2;
    TextView ResultText;
    Integer num1, num2;
    String result;
    //10개 숫자 버튼 배열
    Button[] numButtons = new Button[10];
    //10개 숫자 버튼의 id 값 배열
    Integer[] numBtnIDs = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("계산기");
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnShare = findViewById(R.id.btnShare);

        ResultText = findViewById(R.id.ResultText);

        btnPlus.setOnClickListener(onClickListener);
        btnMinus.setOnClickListener(onClickListener);
        btnMulti.setOnClickListener(onClickListener);
        btnShare.setOnClickListener(onClickListener);

        //숫자 버튼 10개를 대입
        for (int i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = findViewById(numBtnIDs[i]);
        }

        //숫자 버튼 10개에 대해서 클릭 이벤트 처리
        for (int i = 0; i < numBtnIDs.length; i++) {
            final int index = i; //인덱스는 버튼 번호를 뜻함

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //포커스가 되어 있는 에디트 텍스트에 숫자 추가
                    if (input1.isFocused() == true) {
                        num1 = Integer.parseInt(input1.getText().toString() + numButtons[index].getText().toString());
                        input1.setText(Integer.toString(num1));
                    } else if (input2.isFocused() == true) {
                        num2 = Integer.parseInt(input2.getText().toString() + numButtons[index].getText().toString());
                        input2.setText(Integer.toString(num2));
                    } else if (input2.isFocused() == true) {
                        Toast.makeText(MainActivity.this, "항목을 입력하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num1 = Integer.parseInt(input1.getText().toString());
            num2 = Integer.parseInt(input2.getText().toString());

            switch (v.getId()) {
                case (R.id.btnPlus):
                    result = Integer.toString(num1 + num2);
                    break;
                case (R.id.btnMinus):
                    result = Integer.toString(num1 - num2);
                    break;
                case (R.id.btnMulti):
                    result = Integer.toString(num1 * num2);
                    break;
                case (R.id.btnShare):
                    result = Double.toString(num1 / num2);
                    break;
            }
            ResultText.setText(result);
        }
    };
}




