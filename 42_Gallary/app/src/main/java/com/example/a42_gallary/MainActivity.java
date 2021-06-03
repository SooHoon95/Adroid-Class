package com.example.a42_gallary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("갤러리 영화 포스터");

        Gallery gallery = findViewById(R.id.gallery1);
        MyGalleryAdapter myGalleryAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(myGalleryAdapter);
    }//onCreate

    public class MyGalleryAdapter extends BaseAdapter{

        Context context;
        int[] posterId = {R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10};

        public MyGalleryAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
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
            ImageView imageView = new ImageView(context);

            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterId[position]);//데이터가 백개면 백번 돈다.

            imageView.setOnTouchListener(new View.OnTouchListener() { // 지금 자세히 보면 이미지 만드는 getView라는 메소드 안에서 이 터치 리스너를 만드는데 이건 결국
                                                                        // 이미지 만들때 하나하나에 이 리스너를 만들어준다는 뜻.
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterId[position]);

                    return flase; // true로 두면 위에 이미지 안움직임.
                }
            });

            return imageView;
        }
    }



}//MainActivity