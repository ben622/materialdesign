package com.ben.android.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<New> news;
    private IconTouchListener iconTouchListener;

    public IconTouchListener getIconTouchListener() {
        return iconTouchListener;
    }

    public void setIconTouchListener(IconTouchListener iconTouchListener) {
        this.iconTouchListener = iconTouchListener;
    }

    public NewsAdapter(List<New> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.titleView.setText(news.get(position).getTitle());
        holder.descView.setText(news.get(position).getDesc());

        holder.imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    iconTouchListener.startDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView titleView,descView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.id_imageview);
            titleView = itemView.findViewById(R.id.id_titleview);
            descView = itemView.findViewById(R.id.id_descview);
        }
    }
}
