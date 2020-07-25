package com.dance.h2ostudioz.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.dance.h2ostudioz.Constant;
import com.dance.h2ostudioz.R;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by aman on 9/9/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public List<String> galleryImages;
    private Context context;

    public MyAdapter(Context context, List<String> galleryList) {
        this.galleryImages = galleryList;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder viewHolder, final int i) {
        Log.d("ImagaURL ===>",Constant.IMAGE_URL_GALLERY + galleryImages.get(i)+ ".jpg");
        Picasso.with(context)
                .load(Constant.IMAGE_URL_GALLERY + galleryImages.get(i)+ ".jpg")
                .resize(500,500)
//                .networkPolicy(NetworkPolicy.OFFLINE)
                .centerCrop()
                .error(R.drawable.place_holder)
                .into(viewHolder.img);
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.image_dialog);
                dialog.setCanceledOnTouchOutside(true);
                ImageView imageView = (ImageView) dialog.findViewById(R.id.dialog_image);
                Log.d("ImagaURL ===>",Constant.IMAGE_URL_GALLERY + galleryImages.get(i)+ ".jpg");
                Picasso.with(context)
                        .load(Constant.IMAGE_URL_GALLERY + galleryImages.get(i)+ ".jpg")
                        .placeholder(R.drawable.place_holder)
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .error(R.drawable.place_holder)
                        .into(imageView);
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public ViewHolder(final View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);

        }
    }
}
