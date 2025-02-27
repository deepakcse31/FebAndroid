package com.example.febandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<Search> listData;
    private Context context;
    public RecyclerViewAdapter(List<Search> listData,Context context) {
        this.listData = listData;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listItem=layoutInflater.inflate(R.layout.rv_list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(listData.get(position).getTitle());
        holder.tvDes.setText(listData.get(position).getType());
        Glide.with(context).load(listData.get(position).getPoster()).into(holder.imageView);

        // holder.imageView.setImageResource(listData.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView tvName;
        public TextView tvDes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ivimg);
            tvName=itemView.findViewById(R.id.tvname);
            tvDes=itemView.findViewById(R.id.tvdes);

        }
    }
}
