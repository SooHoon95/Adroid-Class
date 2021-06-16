package com.example.a66_quiz__recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context context;
    public CardViewAdapter cardViewAdapter;
    private ArrayList<StudentsInfo> data = null;
    private LayoutInflater inflater = null;
    private int layout = 0;

    public RecyclerAdapter(Context context, ArrayList<StudentsInfo> data, int layout) {
        this.context = context;
        this.data = new ArrayList<StudentsInfo>();
        this.layout = layout;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvcode, tvname, tvdept , tvphone;

        public ViewHolder(View itemView) {
            super(itemView);
            tvcode  = itemView.findViewById(R.id.tv_code);
            tvname  = itemView.findViewById(R.id.tv_name);
            tvdept  = itemView.findViewById(R.id.tv_dept);
            tvphone = itemView.findViewById(R.id.tv_phone);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        //이 메소드가 뷰를 만드는 메소드 임 위에꺼는 세팅만해주는 거(생성자개념)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        holder.
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
