package com.example.bottonnavigationtest.ui.Address;

import android.content.Context;
import android.media.tv.TvContentRating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bottonnavigationtest.Bean.AddressMember;
import com.example.bottonnavigationtest.R;

import java.util.ArrayList;

public class AddressAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<AddressMember> data = null;
    private int layout = 0;
    private LayoutInflater inflater = null;

    public AddressAdapter(Context mContext, int layout, ArrayList<AddressMember> data) {
        this.mContext = mContext;
        this.data = data;
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
        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }
        TextView address_list_name = convertView.findViewById(R.id.address_list_name);
        ImageView iv_faceIcon = convertView.findViewById(R.id.iv_faceIcon);
        TextView address_list_sNUm = convertView.findViewById(R.id.address_list_sNum);

        iv_faceIcon.setImageResource(R.drawable.profiieface);
        address_list_name.setText(data.get(position).getName());
        address_list_sNUm.setText(Integer.toString(data.get(position).getsNum()));

        return convertView;
    }
}
