package com.example.a64_networkjson;

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
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    Context context = null; // 받아오는 컨택스트 *
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<JsonMember> members;

    //생성자가 필요 >> 메인엑티비티에서 이 생성자를 new 해서 쓸거다.

    public NetworkTask(Context context, String mAddr){  // 여기는 정의 하는 컨텍스트*
        this.context = context;
        this.mAddr = mAddr;
        this.members = new ArrayList<JsonMember>();
    }

    @Override
    protected void onPreExecute() {     // 얘는 다이얼로그를 띄운다. 뻉뺑이 도는 걔 (씨발 개 뭔 소리야 썅 ㅋ)
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);  // 스피너는 동그란애가 뺑뺑도는 거
        progressDialog.setTitle("Dialog");
        progressDialog.setMessage("down....");
        progressDialog.show();
        Log.v("Message", "progressDialog");
    }

    //이걸 꼭 적어줘야 한다!!


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
    protected Object doInBackground(Integer... integers) {  //... 은 복수데이터를 가져오겠다는 뜻. 불특정다수의 의미
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        Log.v("Message", "Start Background");
        try{
            URL url = new URL(mAddr); //http:// 뭐시미기밍나ㅓ 라고 생성자를 통해서 주소를 줄거다.
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000); // 무한정 로딩할 수 없기 때문에 10초 동안 로딩하다가 안되면 안된다고 띄운다.

            Log.v("Message", "url check");
            Log.v("Message", mAddr);
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)//http랑 연결 되었을 시 {   // 여기까지 하면 연결됨. 이제 다음은 json 파일 가져와야함
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                Log.v("Message","버퍼 끝");
                while(true){
                    String strline = bufferedReader.readLine();     //위에서 가져온 버퍼드리더 한줄씩 읽기.
                    if(strline == null) break; //읽을 것이 없을 때 break;
                    stringBuffer.append(strline + "\n");
                }
                //가져왔으니까 파싱한다.
                parser(stringBuffer.toString()); //스트링으로 받음
            Log.v("Message","와일문  끝");




        }catch(Exception e){
            e.printStackTrace();
            Log.v("Message", "else");
        }finally {
            try{
                if(bufferedReader != null)  bufferedReader.close();
                if(inputStream != null ) inputStream.close();
                if(inputStreamReader != null ) inputStreamReader.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return members;
        //이제 어뎁터를 만들어야 데이터를 화면에 집어넣어줄 수 있다.
    }


    private  void parser(String str) { //str에 제이슨 파일이 있다.    //넘어오는 건 파라미터. 받을때는 String
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));
            members.clear(); //혹시 어레이 리스트에 뭐가 들어있을까봐 파싱하기 전에 깨끗하게 비우고 시작하려고. 파싱하기전에는 어디에 들어가도 상관이 없다

            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String name = jsonObject1.getString("name");
                int age = jsonObject1.getInt("age");

                ArrayList<String> hobbies = new ArrayList<String>();
                JSONArray jsonArray1 = jsonObject1.getJSONArray("hobbies");
                for(int j=0; j<jsonArray1.length(); j++){
                    String hobby = jsonArray1.getString(j);
                    hobbies.add(hobby);

                    //info도 object 다.
                    JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                    int no = jsonObject2.getInt("no");
                    String id = jsonObject2.getString("id");
                    String pw = jsonObject2.getString("pw");

                    //가져온 데이터들 빈에다가...
                    JsonMember member = new JsonMember(name, age, hobbies, no, id, pw);
                    members.add(member);
                }
            }

            Log.v("Message","Parsing 끝");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}//================
