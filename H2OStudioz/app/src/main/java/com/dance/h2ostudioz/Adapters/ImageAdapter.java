package com.dance.h2ostudioz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.dance.h2ostudioz.Constant;
import com.dance.h2ostudioz.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 6/15/17.
 */

public class ImageAdapter extends BaseAdapter {

    public static LayoutInflater layoutInflater = null;
    private Context context;
    public List<String> galleryImages;

    public ImageAdapter(Context context, ArrayList<String> galleryImages){
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.galleryImages = galleryImages;
    }

    @Override
    public int getCount() {
        return galleryImages.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(context);

//        imageView.setImageResource(galleryImages.get(position));
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
        imageView.setPadding(2,2,2,2);
        Picasso.with(context)
                .load(Constant.IMAGE_URL_GALLERY + galleryImages.get(position)+ ".jpg")
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.place_holder)
                .into(imageView);

        return imageView;

    }
}
