package com.example.a63_datajson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "Status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser();
    }

    private void parser(){
        /* 1. Json 어떻게 가져오지?
            2. 모양 이상하게 되있으니까 그 중에 특정 정보만 받아오려면 어떻게 해야하지?
         */

        //1 단계
        Log.v(TAG,"parser()");
        InputStream inputStream = getResources().openRawResource(R.raw.jsonex); // 파일 연결. >> R.raw에 있는 jsonex에 연결했다.
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        try{
            while((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);  // 제이슨에서 한줄로 자르려고
            }
            Log.v(TAG,"stringBuffer : " + stringBuffer.toString());

            //2단계(?)
            //여기까지 잘 불러와졌다면 이제부터 JSON 사용할거임
            //JSON파일 하나 만들어준다.
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());

            //제이슨은 배열이다 [] 있는거 보면 알 수있다.
            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));

            //어레이처리하려면 반복문 사용한다.
            for(int i = 0; i < jsonArray.length(); i++){
                //제이슨 보면 어레이안에 오브젝트가 있다.
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String name = jsonObject1.getString("name");
                Log.v(TAG,"name : " + name);
                int age = jsonObject1.getInt("age");
                Log.v(TAG,"age : " + age);

                //취미는 배열
                JSONArray jsonArray1 = jsonObject1.getJSONArray("hobbies");
                for(int j = 0; j < jsonArray1.length(); j++) {
                    String hobby = jsonArray1.getString(j);

                    Log.v(TAG, "hobby: " + hobby);
                }

                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                int no = jsonObject2.getInt("no");
                Log.v(TAG ,"no : " + no);
                String id = jsonObject2.getString("id");
                Log.v(TAG ," id : " + id);
                String pw = jsonObject2.getString("pw");
                Log.v(TAG,"pw: " + pw);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(inputStream != null) inputStream.close();
                if(inputStreamReader != null ) inputStreamReader.close();
                if(bufferedReader != null )  bufferedReader.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }//onCreate

}//==========