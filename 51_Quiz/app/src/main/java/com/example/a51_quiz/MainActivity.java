package com.example.a51_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnOk;
    EditText edit1, edit2;
    final static int RValue = 0;
    String userid = "aaa";
    int pwd = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = findViewById(R.id.btnOk);
        edit1 = findViewById(R.id.edit_userId);
        edit2 = findViewById(R.id.edit_userPw);

        btnOk.setOnClickListener(onClickListener);

    }//onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
                if(edit1.getText().toString().equals("aaa") && edit2.getText().toString().equals("1111")){
                    Toast.makeText(MainActivity.this, "Wrong ID / Password", Toast.LENGTH_SHORT).show();
                }else {
                    intent = new Intent(MainActivity.this, SubActivity.class);
                    startActivity(intent);
                }
        }
    };


}