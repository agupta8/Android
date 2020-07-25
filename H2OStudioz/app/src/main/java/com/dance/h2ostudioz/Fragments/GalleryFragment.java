package com.dance.h2ostudioz.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.dance.h2ostudioz.Adapters.ImageAdapter;
import com.dance.h2ostudioz.Adapters.MyAdapter;
import com.dance.h2ostudioz.Adapters.RecyclerItemClickListener;
import com.dance.h2ostudioz.Constant;
import com.dance.h2ostudioz.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    GridView gridView;
    private ImageAdapter imageAdapter;
    private MyAdapter myAdapter;
    ArrayList<String> galleryImages;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.image_gallery);
//        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
//        gridView = (GridView) view.findViewById(R.id.grid_view);
        galleryImages = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            galleryImages.add(i + "");
        }
        myAdapter = new MyAdapter(getActivity(), galleryImages);
        recyclerView.setAdapter(myAdapter);

//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                final Dialog dialog = new Dialog(getActivity());
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.setContentView(R.layout.image_dialog);
//                dialog.setCanceledOnTouchOutside(true);
//                ImageView imageView = (ImageView) dialog.findViewById(R.id.dialog_image);
//                Picasso.with(getContext())
//                        .load(Constant.IMAGE_URL + galleryImages.get(position)+ ".jpg")
//                        .centerCrop()
//                        .placeholder(R.drawable.place_holder)
//                        .error(R.drawable.place_holder)
//                        .into(imageView);
//                dialog.show();
//            }
//        });



        return view;
    }
}
