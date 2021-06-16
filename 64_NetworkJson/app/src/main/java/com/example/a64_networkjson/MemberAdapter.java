package com.example.a64_networkjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MemberAdapter extends BaseAdapter {
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<JsonMember> data = null;
    private LayoutInflater inflater = null;

    public MemberAdapter(Context context, int layout, ArrayList<JsonMember> data) {
        this.mContext = context;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getId();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.layout, parent, false);

        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_age = convertView.findViewById(R.id.tv_age);
        TextView tv_hobbies = convertView.findViewById(R.id.tv_hobbies);
        TextView tv_no = convertView.findViewById(R.id.tv_no);
        TextView tv_id = convertView.findViewById(R.id.tv_id);
        //어레이 리스트에 있는 패스워드는 안쓸거다.
        // 여기까지 셀 하나 넣은거.

        tv_name.setText("name : " + data.get(position).getName());
        tv_age.setText("age : " + data.get(position).getAge());
        tv_hobbies.setText("hobbies : " + data.get(position).getHobbies());
        tv_no.setText("no : " + data.get(position).getNo());
        tv_id.setText("id : " + data.get(position).getId());


        //색 주기
        if (position % 2 == 1) {

            convertView.setBackgroundColor(0x5000ff00);
        }else{
            convertView.setBackgroundColor(0x500000ff);
        }
        return convertView; // 셀 한개씩 반환
    }
}
