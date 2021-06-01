package com.example.a28_quiz10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    RadioGroup rg;
    LinearLayout linear1 , linear2 ;
    Button button;
    ImageView dog, cat, rabbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("좋아하는 동물 선택하기");

        checkBox = findViewById(R.id.cbStart);
        button = findViewById(R.id.select);
        rg = findViewById(R.id.rg01);
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        dog =findViewById(R.id.imgdog);
        cat = findViewById(R.id.imgcat);
        rabbit = findViewById(R.id.imgrabbit);

        checkBox.setOnCheckedChangeListener(mChangeListener);
        button.setOnClickListener(mClickListener);
        rg.setOnClickListener(mClickListener);

    }//onCreate

    //체크박스 체크되면 여기서 처리
    CompoundButton.OnCheckedChangeListener mChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(checkBox.isChecked() == true){
                linear1.setVisibility(View.VISIBLE);
            }else{
                linear1.setVisibility(View.INVISIBLE);
                linear2.setVisibility(View.VISIBLE);
            }
        }
    };//체크박스 리스너 끝


    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 라디오 그룹에서 체크된 아이디 가져오기
            int id = rg.getCheckedRadioButtonId();
            // 라디오 버튼 정의하기
//            RadioButton rb = findViewById(id);

            switch (id){
                case R.id.dog:
                    dog.setVisibility(View.VISIBLE);
                    cat.setVisibility(View.INVISIBLE);
                    rabbit.setVisibility(View.INVISIBLE);
                    break;
                case R.id.cat:
                    cat.setVisibility(View.VISIBLE);
                    dog.setVisibility(View.INVISIBLE);
                    rabbit.setVisibility(View.INVISIBLE);
                    break;
                case R.id.rabbit:
                    rabbit.setVisibility(View.VISIBLE);

                    dog.setVisibility(View.INVISIBLE);
                    cat.setVisibility(View.INVISIBLE);
                    break;
                default:
                    Toast.makeText(getApplicationContext(),"동물을 선택하세요", Toast.LENGTH_SHORT).show();
            }//switch
        }
    };// End of ClickListener


}//MainActivity