package com.example.bottonnavigationtest.ui.Address;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bottonnavigationtest.Bean.AddressMember;
import com.example.bottonnavigationtest.R;

import java.util.ArrayList;

public class DetailAdapter extends BaseAdapter {
   private ArrayList<AddressMember> data = null;
   private Context mContext = null;
   private int layout = 0;
   private LayoutInflater inflater = null;


    public DetailAdapter(Context mContext, int layout, ArrayList<AddressMember> data) {
        this.data = data;
        this.mContext = mContext;
        this.layout = layout;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getsNum();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
        }
        TextView number1 = convertView.findViewById(R.id.custom_detail_number1);
        TextView number2 = convertView.findViewById(R.id.custom_detail_number2);
        TextView workplace = convertView.findViewById(R.id.custom_detail_workplace);
        TextView email = convertView.findViewById(R.id.custom_detail_email);
        TextView address = convertView.findViewById(R.id.custom_detail_address);
//        TextView sNum = convertView.findViewById(R.id.custom_detail_sNum);

        number1.setText(data.get(position).getNumber());
//        sNum.setText(data.get(position).getsNum());
        if(data.get(position).getNumber2().isEmpty()){
            number2.setText("");
        }else{
            number2.setText(data.get(position).getNumber2());
        }
        if(data.get(position).getWorkPlace().isEmpty()){
            workplace.setText("");
        }else{
            workplace.setText(data.get(position).getWorkPlace());
        }
        if(data.get(position).getEmail().isEmpty()){
            email.setText("");
        }else{
            email.setText(data.get(position).getEmail());
        }
        if (data.get(position).getAddress().isEmpty()){
            address.setText("");
        }else{
            address.setText(data.get(position).getAddress());
        }


        return convertView;
    }
}
