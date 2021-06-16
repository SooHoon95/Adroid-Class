package com.example.bottonnavigationtest.NetworkTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.bottonnavigationtest.Bean.AddressMember;
import com.example.bottonnavigationtest.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {
    Context context = null;
//    ProgressDialog progressDialog = null;
    String mAddr = null;
    ArrayList<AddressMember> members = null;
    //Network Task를 검색, 입력, 수정, 삭제 구분없이 하나로 사용키 위해 생성자 변수추가.
    String where = null;
    int seqNum = 0;

    public NetworkTask(Context context, String mAddr, String where) {
        this.context = context;
        this.mAddr = mAddr;
        this.members = new ArrayList<AddressMember>();
        this.where = where;
    }

    public NetworkTask(Context context, String mAddr, String where, int seqNum) {
        this.context = context;
        this.mAddr = mAddr;
        this.where = where;
        this.seqNum = seqNum;
    }
    //    @Override
//    protected void onPreExecute() {
//        progressDialog = new ProgressDialog(context); // 나를 부른놈이 누구냐 해서 거기로 갈거(?)
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.setTitle("Dialog");
//        progressDialog.setMessage("Get...");
//        progressDialog.show();
//    }
//
//    @Override
//    protected void onPostExecute(Object o) {
//        super.onPostExecute(o);
//        progressDialog.dismiss();
//    }
//
//    @Override
//    protected void onCancelled() {
//        super.onCancelled();
//        progressDialog.dismiss();
//    }

    @Override
    protected Object doInBackground(Integer... integers) {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String result = null; // CURD시 잘 했는지를 reuslt를 통해서 알거야.

        try{
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);

            if(httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while(true){
                    String strline = bufferedReader.readLine();
                    if(strline == null) break;
                    stringBuffer.append(strline + "\n");
                }
                if(where.equals("select")){
                    parserSelect(stringBuffer.toString());

                }else if(where.equals("detail")){
                    parseDetail(stringBuffer.toString());
                }else {
                    result = parserAction(stringBuffer.toString());
                }


            }
        }catch (Exception e){
          e.printStackTrace();
        }finally {
            try{
                if(bufferedReader != null) bufferedReader.close();
                if(inputStream != null) inputStream.close();
                if(inputStreamReader != null) inputStreamReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(where.equals("select")){
            return members;
        }else {
            return result;
        }
    }

    private String parserAction(String str){
        String returnValue = null;
        try{
            JSONObject jsonObject = new JSONObject(str);
            returnValue = jsonObject.getString("result");
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnValue;
    }

    public void parserSelect(String str) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("Address_name"));
            members.clear();

            //어레이니까 포문 돌려서 파싱
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

                String name = jsonObject1.getString("name");
                int sNum = jsonObject1.getInt("sNum");

                AddressMember member = new AddressMember(name, sNum);
                members.add(member);
            }
                Log.v("test",members.get(1).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseDetail(String str){

        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("Address_detail_info"));
            members.clear();

            //어레이니까 포문 돌려서 파싱
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

                String name = jsonObject1.getString("name");
                String number = jsonObject1.getString("number");
                String number2 = jsonObject1.getString("number2");
                String workPlace = jsonObject1.getString("workPlace");
                String email = jsonObject1.getString("Email");
                String address = jsonObject1.getString("address");
//                int sNum = jsonObject1.getInt("sNum");

                AddressMember member = new AddressMember(name, number, number2, workPlace, email, address);
                members.add(member);

                for(int i=0; i<members.)

            }
//            Log.v("test",members.et(1).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}//==============