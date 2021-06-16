package com.example.bottonnavigationtest.ui.Address;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bottonnavigationtest.Bean.AddressMember;
import com.example.bottonnavigationtest.MainActivity;
import com.example.bottonnavigationtest.NetworkTask.NetworkTask;
import com.example.bottonnavigationtest.R;

import java.util.ArrayList;

public class AddressDetailActivity extends AppCompatActivity {

    private Context mContext;
    private TextView tv_name, tv_sNum;
    //detail info
    private TextView detailNumber, detailNumber2, detailWorkplace, detailEmail, detailAddress;
    private ImageView iv_call, iv_message;
    private Button btn_delete, btn_edit;

    private ArrayList<AddressMember> detailMembers;
    private DetailAdapter detailAdapter = null;

    private ListView listView;
    private String urlAddr = null;
    private String macIP = "192.168.2.10";
    private String detailName = null;
    private String sNum = null;
    private int seqNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_detail);
        setTitle("상세정보");

        Intent intent = getIntent();
        detailName = intent.getStringExtra("name");
        sNum = intent.getStringExtra("sNum");
        int seqNum = Integer.parseInt(sNum);

        Log.v("Message","sNum = " + sNum + "seqNum = " + seqNum);

        tv_name = findViewById(R.id.tv_detail_name);
        tv_sNum = findViewById(R.id.tv_detail_sNum);
        iv_call = findViewById(R.id.iv_call);
        iv_message = findViewById(R.id.iv_message);
        btn_delete = findViewById(R.id.btn_delete);
        btn_edit = findViewById(R.id.btn_edit);

        //detail_info
        listView = findViewById(R.id.detail_info);
        detailNumber = findViewById(R.id.custom_detail_number1);
        detailNumber2 = findViewById(R.id.custom_detail_number2);
        detailWorkplace = findViewById(R.id.custom_detail_workplace);
        detailEmail = findViewById(R.id.custom_detail_email);
        detailAddress = findViewById(R.id.custom_detail_address);

        iv_call.setOnClickListener(mClickListener);
        iv_message.setOnClickListener(mClickListener);
        btn_delete.setOnClickListener(mClickListener);
        btn_edit.setOnClickListener(mClickListener);

        urlAddr = "http://" + macIP + ":8080/project_address/Address_detail.jsp?sNum=" + seqNum;
//        "http://192.168.2.10:8080/project_address/Address_detail.jsp?sNum=1" + seqNum;

    }

    @Override
    protected void onResume() { // 이 리슘에 데이터 부르는게 들어간다.
        super.onResume();
        connectGetData(); //*******************
    }

    private void connectGetData(){
        try{
            NetworkTask networkTask = new NetworkTask(AddressDetailActivity.this, urlAddr,"detail", seqNum);
            Object obj = networkTask.execute().get();
            detailMembers = (ArrayList<AddressMember>) obj;
            Log.v("Message","error Test 1");


            //detail info 채우기
            tv_name.setText(detailName);
            tv_sNum.setText(sNum);
            Log.v("Message","error Test 2");
            Log.v("Message","error Test 3");
            detailAdapter = new DetailAdapter(AddressDetailActivity.this,R.layout.detail_customp_layout, detailMembers);
            Log.v("Message","error Test 4");
            listView.setAdapter(detailAdapter);
            Log.v("Message","error Test 5");

//            listView.setOnItemClickListener(onItemClickListener);
//            listView.setOnItemLongClickListener(onItemLongClickListener);

        }catch (Exception e){
            e.printStackTrace();
            Log.v("AA","Error 1111");
        }
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.iv_call:
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse(tv_name.getText().toString()));
                    startActivity(intent);
                    break;
                case R.id.iv_message:
//                    intent = new Intent(Intent.CATEGORY_APP_MESSAGING, Uri.parse());
                case R.id.btn_edit:
//                    intent = new Intent(AddressDetailActivity.this, UpdateDetailActivity.class);
//                    intent.putExtra("macIP",urlAddr);
//                    startActivity(intent);
            }
        }
    };
}