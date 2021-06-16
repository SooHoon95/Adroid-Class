package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1 , edit2 ;
    Button Plus,Minus, Multi, Div;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.input1);
        edit2 = findViewById(R.id.input2);

        Plus = findViewById(R.id.btnPlus);
        Minus = findViewById(R.id.btnMinus);
        Multi = findViewById(R.id.btnMulti);
        Div = findViewById(R.id.btnShare);

        Plus.setOnClickListener(mClickListener);
        Minus.setOnClickListener(mClickListener);
        Multi.setOnClickListener(mClickListener);
        Div.setOnClickListener(mClickListener);
    }//onCreate

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer input1 = Integer.parseInt(edit1.getText().toString());
            Integer input2 = Integer.parseInt(edit2.getText().toString());
            switch (v.getId()){
                case R.id.btnPlus:
                    result = Integer.toString(input1 + input2);
                    break;
                case R.id.btnMinus:
                    result = Integer.toString(input1 - input2);
                    break;
                case R.id.btnMulti:
                    result = Integer.toString(input1 * input2);
                    break;
                case R.id.btnShare:
                    result = Double.toString((double)input1 / (double)input2);
                    break;
            }//switch
            Toast.makeText(MainActivity.this,"계산결과는 " + result+ " 입니다.", Toast.LENGTH_SHORT).show();

        }
    };

}//MainActivity