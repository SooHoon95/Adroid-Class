package com.example.a57_fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class ToolBarFragment extends Fragment {

    EditText editText = null;
    Button button = null;
    SeekBar seekBar = null;
    int seekValue = 10;

    ToolbarListener activityCallback;
    //-------------------------------
    //MainActivity와의 통신을 위해 interface를 사용
    //MainActivity에서는 inplements를 사용
    //--------------------------------

    public interface ToolbarListener{
        public void onBUttonClick(int position, String text);
    }
    //--------------------
    //fragment에서서는 onAttach() 메소드가 가장 먼저 실행 됌.
    //--------------------


    @Override
    public void onAttach(Context context) {
        //그림그리는 애 아니라서 ToolbarListener랑 다시 연결해줘야함
        super.onAttach(context);
        try {
            //context는 현재위치를 알려준다
            activityCallback = (ToolbarListener) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    //onCreate 아니고 onCreateView
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //그림올리겠다는 뜻
        View view = inflater.inflate(R.layout.fragment_tool_bar, container, false);
        editText = view.findViewById(R.id.f1_edit);
        button = view.findViewById(R.id.f1_button);
        seekBar = view.findViewById(R.id.f1_seek);

        button.setOnClickListener(mClickListener);
        seekBar.setOnSeekBarChangeListener(mSeekBarVhangedListener);

        return view;
    }

    SeekBar.OnSeekBarChangeListener mSeekBarVhangedListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekValue = progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    View.OnClickListener mClickListener = new View.OnClickListener() {
        //실제로는 MainActivity의 onButtonClick()에서 실행
        @Override
        public void onClick(View v) {
            activityCallback.onBUttonClick(seekValue, editText.getText().toString());


        }
    };


}