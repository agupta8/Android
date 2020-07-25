package com.dance.h2ostudioz.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.dance.h2ostudioz.YouTube.AppController;
import com.dance.h2ostudioz.YouTube.YoutubeData;
import com.dance.h2ostudioz.R;
import com.dance.h2ostudioz.YouTube.Item;
import com.dance.h2ostudioz.YouTube.ThumbnailAdapter;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideosFragment extends Fragment {

    private static final int PAGE_START = 0;
    RecyclerView recyclerView;
    private List<Item> thumbnailList = new ArrayList<>();
    private ThumbnailAdapter thumbnailAdapter;
    LinearLayoutManager mLayoutManager;
    private static String TAG = VideosFragment.class.getSimpleName();
    public final String API_KEY = "&key=AIzaSyDbBLnETr9ojmGtzgUrX1E_1qQvickvhDI";
    private final String CHANNEL_ID = "UC4lBquxz8XG0Gd9tOsVi3Zg&maxResults=20";
    private final String BASE_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=";
    private final String PAGE_TOKEN = "&pageToken=";
    YoutubeData data;
//    private String urlJsonObj = "https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=UC4lBquxz8XG0Gd9tOsVi3Zg&pageToken=&key=AIzaSyDbBLnETr9ojmGtzgUrX1E_1qQvickvhDI";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videos, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        if (data == null)
            makeJsonObjectRequest("");
        else {
            makeJsonObjectRequest(data.getNextPageToken());
        }
        return view;
    }

    private void makeJsonObjectRequest(String pageToken) {
        String url = BASE_URL + CHANNEL_ID + PAGE_TOKEN + pageToken + API_KEY;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                Gson gson = new Gson();
                YoutubeData data = gson.fromJson(response.toString(), YoutubeData.class);

                thumbnailList = data.getItems();
                thumbnailAdapter = new ThumbnailAdapter(thumbnailList);
                mLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(thumbnailAdapter);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.v(TAG, "Volley Error: ", "Internet not connected");
                Toast.makeText(getContext(),
                        "Internet not connected", Toast.LENGTH_LONG).show();
            }
        });

       AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
}
