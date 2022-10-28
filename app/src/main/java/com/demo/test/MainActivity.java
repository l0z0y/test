package com.demo.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recy);
        for (int i = 0; i < 10; i++) {
            urls.add("http://static.runoob.com/images/demo/demo2.jpg");
            urls.add("https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
            urls.add("https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg");
            urls.add("https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg");
        }

        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 4);
        recyclerView.setLayoutManager(layoutManager);

    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {
        @NonNull
        @Override
        public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = View.inflate(MainActivity.this, R.layout.item, null);
            ImageItemView itemView = new ImageItemView(MainActivity.this);
            return new MyViewHoder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
            Glide.with(MainActivity.this).load(urls.get(position)).centerCrop().into(holder.pic);
            holder.pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    ImageView view = new ImageView(MainActivity.this);
//                    Glide.with(MainActivity.this).load(urls.get(holder.getBindingAdapterPosition())).into(view);
//                    new AlertDialog.Builder(MainActivity.this).setView(view).create().show();
                    ImageDialog imageDialog = new ImageDialog(MainActivity.this);
                    imageDialog.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return urls.size();
        }
    }

    private class MyViewHoder extends RecyclerView.ViewHolder {
        private ImageView pic;

        public MyViewHoder(@NonNull ImageItemView itemView) {
            super(itemView);
//            pic = itemView.findViewById(R.id.pic);
            pic = itemView.imageView;

        }
    }
}