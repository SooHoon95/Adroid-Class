package com.example.customadapterview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Weather> data;
    private LayoutInflater layoutInflater;
    private int layout= 0; // 레이아웃 번호

    public WeatherAdapter(Context mContext, int layout, ArrayList<Weather> data){
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getDay();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView=layoutInflater.inflate(this.layout, parent, false);
        }
        TextView tv_day = convertView.findViewById(R.id.tv_day);
        ImageView in_icon = convertView.findViewById(R.id.iv_weather);
        TextView tv_comment = convertView.findViewById(R.id.tv_comment);

        tv_day.setText(data.get(position).getDay());
        in_icon.setImageResource(data.get(position).getIcon());
        tv_comment.setText(data.get(position).getComment());

        if(position %2 == 1){
            convertView.setBackgroundColor(0x5000ff00);
        }else{
            convertView.setBackgroundColor(0x2000ff00);
        }
        Log.v("Message","55555555555555555555");
        return convertView;
    }
}
