package com.example.a38_customadapterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    private Context mContext = null; //컨텍스트란 현재 이 앱에 어디 위치에 있다(?) xml 이라고 생각해도 무방
    private int layout = 0; // 레이아웃 번호
    private ArrayList<Weather> data = null;
    private LayoutInflater inflater = null; // .View 인걸로 봐서 그림임을 알 수 있다.

    public WeatherAdapter(Context mContext, int layout, ArrayList<Weather> data) { //인플레이터는 정해져있는 애라서 새로 만드는 컨스트럭트에는 넣어주지 않는다.
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;

        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { //데이터가 몇개냐  위의 data 몇개냐는 뜻
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getDay(); // position 이 몇번째를 클릭했는지 알려줄거임
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
        TextView tv_day = convertView.findViewById(R.id.tv_day);
        ImageView iv_icon = convertView.findViewById(R.id.iv_weather);
        TextView tv_comment = convertView.findViewById(R.id.tv_comment);

        tv_day.setText(data.get(position).getDay() + " ");
        iv_icon.setImageResource(data.get(position).getIcon());
        tv_comment.setText(data.get(position).getComment());

        if(position %2 == 1){
            convertView.setBackgroundColor(0x5000ff00);
        }else{
            convertView.setBackgroundColor(0x2000ff00);
        }
        return convertView;
    }
}
