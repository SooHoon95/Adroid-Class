package com.example.a66_quiz__recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class CardViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<StudentsInfo > data = null;
    private int layout = 0;
    private LayoutInflater inflater = null;

    public CardViewAdapter(Context context, int layout, ArrayList<StudentsInfo> data){
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
        //Layout연결
        convertView = inflater.inflate(this.layout,parent,false);
        TextView tv_code = convertView.findViewById(R.id.tv_code);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_dept = convertView.findViewById(R.id.tv_dept);
        TextView tv_phone = convertView.findViewById(R.id.tv_phone);

        tv_code.setText(data.get(position).getCode());
        tv_name.setText(data.get(position).getName());
        tv_dept.setText(data.get(position).getDept());
        tv_phone.setText(data.get(position).getPhone());

        return convertView;
    }
}
