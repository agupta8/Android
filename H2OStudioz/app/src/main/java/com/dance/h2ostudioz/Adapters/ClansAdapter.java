package com.dance.h2ostudioz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dance.h2ostudioz.Activity.ClanDescription;
import com.dance.h2ostudioz.Constant;
import com.dance.h2ostudioz.Models.Clans;
import com.dance.h2ostudioz.R;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 6/26/17.
 */

public class ClansAdapter extends RecyclerView.Adapter<ClansAdapter.MyViewHolder> {

    private Context mContext;
    private List<Clans> albumList;

    public ClansAdapter(Context mContext, List<Clans> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, classes;
        public ImageView thumbnail;
        List<Clans> albumList = new ArrayList<Clans>();
        Context mContext;


        public MyViewHolder(View view, Context mContext, List<Clans> albumList) {
            super(view);
            view.setOnClickListener(this);
            this.albumList = albumList;
            this.mContext = mContext;
            title = (TextView) view.findViewById(R.id.title);
            classes = (TextView) view.findViewById(R.id.classes);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            thumbnail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Clans clans = this.albumList.get(position);
            Intent intent = new Intent(this.mContext, ClanDescription.class);
            intent.putExtra("Image", clans.getThumbnail());
            intent.putExtra("Name", clans.getName());
            intent.putExtra("Classes", clans.getClasses());
            intent.putExtra("Description", clans.getDescription());
            this.mContext.startActivity(intent);
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.clans_card, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView, mContext, albumList);
        return myViewHolder;
    }

    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Clans album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.classes.setText(album.getClasses());
        Log.d("Image Url ====>",Constant.IMAGE_URL + album.getThumbnail()+ ".jpg");
        Picasso.with(mContext)
                .load(Constant.IMAGE_URL + album.getThumbnail()+ ".jpg")
                .error(R.drawable.place_holder)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
