package com.example.a25__checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2,cb3,cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb_01);
        cb2 = findViewById(R.id.cb_02);
        cb3 = findViewById(R.id.cb_03);
        cb4 = findViewById(R.id.cb_04);

        cb1.setOnCheckedChangeListener(checkChangeListener);
        cb2.setOnCheckedChangeListener(checkChangeListener);
        cb3.setOnCheckedChangeListener(checkChangeListener);
        cb4.setOnCheckedChangeListener(checkChangeListener);

    }//omCreate

    CompoundButton.OnCheckedChangeListener checkChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String str = "";

            if (cb1.isChecked()){
                str += "운동";
            }
            if(cb2.only()==true){
                    str +=", 요리";
            }
            if(cb3.isChecked() == true){
                    str +=", 독서";
            }
            if(cb4.isChecked()==true){
                str += ", 여행";
            }

//            switch (buttonView.getId()){
//
//                case R.id.cb_01:
//                    if(isChecked == true){
//                        str += "운동";
//                        while (int i=0; i<4; i++){
//                            result[i] = str;
//                        }
//                    }
//                    break;
//                case R.id.cb_02:
//                    if(isChecked == true){
//                        str += "요리";
//                    }
//                    break;
//                case R.id.cb_03:
//                    if(isChecked == true){
//                        str += "독서";
//                    }
//                    break;
//                case R.id.cb_04:
//                    if(isChecked == true){
//                        str += "여행";
//                    }
//                    break;
//            }//switch
                Toast.makeText(MainActivity.this,str+" is checked", Toast.LENGTH_SHORT).show();

        }
    };




}//MainActivity