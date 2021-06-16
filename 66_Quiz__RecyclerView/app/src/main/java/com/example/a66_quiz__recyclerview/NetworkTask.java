package com.example.a66_quiz__recyclerview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<StudentsInfo> students;


    public NetworkTask(Context context, String mAddr) {
        this.context = context;
        this.mAddr = mAddr;
        this.students = new ArrayList<StudentsInfo>();
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);  // 스피너는 동그란애가 뺑뺑도는 거
        progressDialog.setTitle("Dialog");
        progressDialog.setMessage("down....");
        progressDialog.show();
        super.onPreExecute();
    }


    @Override
    protected void onProgressUpdate(String... values) { // 얘는 테스크가 길때 진행상황을 보여주는 것
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) { // 끝났다는 걸 알려줌
        super.onPostExecute(o);
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() { //실행하다가 캔슬됐을때 뭔가를 띄워줄 수 있는 메소드
        super.onCancelled();
    }

    @Override
    protected Object doInBackground(Integer... integers) {

        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(mAddr); //http:// 뭐시미기밍나ㅓ 라고 생성자를 통해서 주소를 줄거다.
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000); // 무한정 로딩할 수 없기 때문에 10초 동안 로딩하다가 안되면 안된다고 띄운다.

            Log.v("test", "mAddr : " + mAddr);
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)//http랑 연결 되었을 시 {   // 여기까지 하면 연결됨. 이제 다음은 json 파일 가져와야함
                inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            while (true) {
                String strline = bufferedReader.readLine();     //위에서 가져온 버퍼드리더 한줄씩 읽기.
                if (strline == null) break; //읽을 것이 없을 때 break;
                stringBuffer.append(strline + "\n");
            }
            //가져왔으니까 파싱한다.
            parser(stringBuffer.toString()); //스트링으로 받음


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (inputStream != null) inputStream.close();
                if (inputStreamReader != null) inputStreamReader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    private void parser(String str) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));
            students.clear(); //혹시 어레이 리스트에 뭐가 들어있을까봐 파싱하기 전에 깨끗하게 비우고 시작하려고. 파싱하기전에는 어디에 들어가도 상관이 없다

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String code = jsonObject1.getString("code");
                String name = jsonObject1.getString("name");
                String dept = jsonObject1.getString("dept");
                String phone = jsonObject1.getString("phone");


                StudentsInfo studentsInfo = new StudentsInfo(code, name, dept, phone);
                students.add(studentsInfo);


                //가져온 데이터들 빈에다가...
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }









}//===========
