package com.example.a31_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weight, height;
    Button button;
    TextView textView1 , textView2;
    RadioGroup radioGroup;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        button = findViewById(R.id.calculate);
        textView1 = findViewById(R.id.resultText1);
        textView2 = findViewById(R.id.resultText2);
        radioGroup = findViewById(R.id.rg01);



    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             result = (double)Integer.parseInt(weight.getText().toString()) /
                     (((double)Integer.parseInt(height.getText().toString())/100) * ((double)Integer.parseInt(height.getText().toString())/100));


               if(result < 18.9){
                   textView2.setText("저체중 입니다");
                   textView1.setText( String.format("%.2f",result));
               }else if ( result < 23.9){
                   textView2.setText("정상체중 입니다.");
                   textView1.setText( String.format("%.2f",result));
               }else if ( result <24.9){
                   textView2.setText("과체중 입니다.");
                   textView1.setText( String.format("%.2f",result));
               }else if ( result < 29.9){
                   textView2.setText("초도비만 입니다.");
                   textView1.setText( String.format("%.2f",result));
               }else if (result < 39.9){
                   textView2.setText("중도비만 입니다.");
                   textView1.setText( String.format("%.2f",result));
               }else if (result >=40){
                   textView2.setText("고도비만 입니다.");
                   textView1.setText( String.format("%.2f",result));
               }

        }
    });

    }//onCreate

}//MainActivity