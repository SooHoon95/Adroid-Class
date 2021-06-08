package com.example.a63_jsonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parse();
//        Log.v(TAG,
    }

    public void parse(){

        Log.v(TAG,"parse()");
        InputStream inputStream = getResources().openRawResource(R.raw.students); // Connect File
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();
        String cutline = null; // 한 줄씩 자르기

        try{
            while ((cutline = bufferedReader.readLine()) != null){ // 한줄이라도 들어있으면 한줄씩 잘라서 데이터 불러온다.
                stringBuffer.append(cutline); // 자른거 스트링 버퍼에다가 어레이리스트 처럼 한줄씩 넣어준다.
                }
            Log.v(TAG,"stringbuffer : " + stringBuffer);

            //전체 틀 인식
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            //각각 단위별로 인식하기 위해서 배열처리
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String code = jsonObject1.getString("code");
                Log.v(TAG,"code: " + code);

                String name = jsonObject1.getString("name");
                Log.v(TAG,"name :" + name);

                String dept = jsonObject1.getString("dept");
                Log.v(TAG,"dept: "+ dept);

                String phone = jsonObject1.getString("phone");
                Log.v(TAG,"phone: " + phone);
            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(inputStream != null) inputStream.close();
                if(inputStreamReader != null ) inputStreamReader.close();
                if(bufferedReader != null ) bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }//onCreate

}//===============