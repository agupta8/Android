package com.dance.h2ostudioz.YouTube;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dance.h2ostudioz.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by aman on 8/19/17.
 */

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.MyViewHolder>{

    List<Item> thumbnailList;
    private Context context;

    public ThumbnailAdapter(List<Item> thumbnailList){
        this.thumbnailList = thumbnailList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView thumbnail;
        public ImageView video_clicker;
        public MyViewHolder(View view){
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.recycler_item_thumbnail);
            video_clicker = (ImageView) itemView.findViewById(R.id.video_clicker);
            context = view.getContext();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Context context = holder.thumbnail.getContext();
        final Item thumb = thumbnailList.get(position);
        Picasso.with(context).load(thumb.getSnippet().getThumbnails().getHigh().getUrl()).into(holder.thumbnail);
        holder.video_clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YoutubeVideo.class);
                intent.putExtra("VideoId", thumb.getId().getVideoId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return thumbnailList.size();
    }

}
