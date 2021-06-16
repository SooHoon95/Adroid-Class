package com.example.a65_quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsAdapter extends BaseAdapter {
    private Context context;
    private int layout ;
    private ArrayList<StudentsInfo> data;
    private LayoutInflater inflater;

    public StudentsAdapter(Context context, int layout, ArrayList<StudentsInfo> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getCode();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.layout , parent, false);

        TextView tv_code = convertView.findViewById(R.id.tv_code);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_dept = convertView.findViewById(R.id.tv_dept);
        TextView tv_phone = convertView.findViewById(R.id.tv_phone);

        tv_code.setText("Code : " + data.get(position).getCode());
        tv_name.setText("Name : " + data.get(position).getName());
        tv_dept.setText("Dept : " + data.get(position).getDept());
        tv_phone.setText("Phone : " + data.get(position).getPhone());

        //색 주기
        if (position % 2 == 1) {

            convertView.setBackgroundColor(0x5000ff00);
        }else{
            convertView.setBackgroundColor(0x500000ff);
        }

        return convertView;
    }
}
