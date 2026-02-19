package com.example.febandroid;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    List<MovieItem> listdata;

    public MovieAdapter(List<MovieItem> listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.rvlist_item, parent, false);
       ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("Data",listdata.get(position).getTitle());

        holder.textView.setText(listdata.get(position).getTitle());
        holder.textView1.setText(String.valueOf(listdata.get(position).getYear()));

        Glide.with(holder.itemView)
                .load(listdata.get(position).getImgPoster())
                .into(holder.imageView);
    }



//    }
    @Override
    public int getItemCount() {
        return listdata.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
        public TextView textView1;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.ivimage);
            this.textView = (TextView) itemView.findViewById(R.id.tvName);
            this.textView1 = (TextView) itemView.findViewById(R.id.tvDescription);
        }
        }
}

