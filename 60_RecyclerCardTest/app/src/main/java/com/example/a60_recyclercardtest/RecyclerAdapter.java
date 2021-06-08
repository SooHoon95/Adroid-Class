package com.example.a60_recyclercardtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    //data만들기
    private String[] titles = {"Monday 월", "Tuesday 화", "Wednesday 수","Thursday 목",
                                "Friday 금" , "Saturday 토 " , "Sunday 일"};
    private String[] details = {"월요일 기상정보", "화요일 기상정보" ,"수요일 기상정보", "목요일 기상정보",
                                "금요일 기상정보", "토요일 기상정보", "일요일 기상정보"};
    private int[] images = {R.drawable.w1,R.drawable.w2,R.drawable.w3,R.drawable.w4,
                            R.drawable.w5,R.drawable.w6,R.drawable.w7};


    //그림보여주는 부분인 ViewHolder를 만들어준다.
    //클라스안에 클라스가 들어가 있다.
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    //정보는 디테일에 있는 포지션값을 보여줄거다
                    Snackbar.make(v, details[position], Snackbar.LENGTH_LONG).setAction("test",null).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       //이 메소드가 뷰를 만드는 메소드 ㅇ. 위에꺼는 세팅만해주는 거(생성자개념)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    //새로운 값을 넣어주는 애
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
       //뷰홀더 쓰는 애
        holder.itemTitle.setText(titles[position]);
        holder.itemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);
        //전체 몇갠지 알려줘야지
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}//==========
