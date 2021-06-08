package com.example.a57_fragmenttest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {

   TextView textView = null;

    @Nullable
    @Override
    // 메인 화면 띄웠을 때, 이 fragment 하고 그 위에 있는 textView를 띄우기 위함.
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);


        //TextView 연결
        textView = view.findViewById(R.id.f2_text);
        return view;
    }

    public void changedTextProperties(int fontSize, String str){
        Log.v("Message","test1");
        textView.setTextSize(fontSize);
        textView.setText(str);
    }


}