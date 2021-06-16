package com.example.personalproject.ui.Address;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.personalproject.Bean.AdressMember;

import java.util.ArrayList;

public class Adressadapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<AdressMember> data = null;
    private int layout = 0;
    private LayoutInflater inflater = null;

    public Adressadapter(Context mContext, ArrayList<AdressMember> data, int layout) {
        this.mContext = mContext;
        this.data = data;
        this.layout = layout;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
