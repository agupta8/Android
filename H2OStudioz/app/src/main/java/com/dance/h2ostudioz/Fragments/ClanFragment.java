package com.dance.h2ostudioz.Fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dance.h2ostudioz.Adapters.ClansAdapter;
import com.dance.h2ostudioz.Models.Clans;
import com.dance.h2ostudioz.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ClanFragment extends Fragment {

    private RecyclerView recyclerView;
    private ClansAdapter adapter;
    private List<Clans> clansList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clan, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Clan");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        clansList = new ArrayList<>();
        adapter = new ClansAdapter(getActivity(), clansList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareClans();

        try {
            Picasso.with(getContext()).load(R.drawable.clans_cover).into((ImageView) view.findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }


    private void prepareClans() {
        String[] cover = new String[]{
                "Ajay", "Akshatha", "Bana", "Bhanu", "Brindha", "Deeptha", "Himadri", "Kailas", "Narmadha", "Natesan", "Neha", "Praveena", "Shilpa", "Shruthi", "Varun", "Vinoth", "Yogesh"};

        Clans a = new Clans("Ajay", "FreeStyle/Bollywood", getString(R.string.Ajay), cover[0]);
        clansList.add(a);

        a = new Clans("Akshatha Mahadev", "HipHop/Zumba/Bollywood", getString(R.string.Akshatha_mahadev), cover[1]);
        clansList.add(a);

        a = new Clans("Banashree", "HipHop/Bollywood", getString(R.string.Banashree), cover[2]);
        clansList.add(a);

        a = new Clans("Bhanu", "FreeStyle/Contemporary", getString(R.string.Bhanu), cover[3]);
        clansList.add(a);

        a = new Clans("Brinda Sundar", "HipHop/Bollywood", getString(R.string.Brindha_Sundar), cover[4]);
        clansList.add(a);

        a = new Clans("Deeptha", "Bharatanatyam", getString(R.string.Deeptha), cover[5]);
        clansList.add(a);

        a = new Clans("Himadri", "Bollywood", getString(R.string.Himadri), cover[6]);
        clansList.add(a);

        a = new Clans("Kailas", "HipHop/Locking-Popping/Bollywood", getString(R.string.Kailas), cover[7]);
        clansList.add(a);

        a = new Clans("Narmadha", "FreeStyle/Bollywood", getString(R.string.Narmadha), cover[8]);
        clansList.add(a);

        a = new Clans("Natesan Sivagnanam", "Bollywood/Contemporary/Zumba", getString(R.string.Natesan_Sivagnanam), cover[9]);
        clansList.add(a);

        a = new Clans("Neha Gupta", "Contemporary/Zumba/Bollywood", getString(R.string.Neha_Gupta), cover[10]);
        clansList.add(a);

        a = new Clans("Praveena", "Bharatanatyam/Mohiniyattam", getString(R.string.Praveena), cover[11]);
        clansList.add(a);

        a = new Clans("Shilpa", "Bollywood", getString(R.string.Shilpa), cover[12]);
        clansList.add(a);

        a = new Clans("Shruthi", "Contemporary/FreeStyle", getString(R.string.Shruthi), cover[13]);
        clansList.add(a);

        a = new Clans("Varun", "FreeStyle/Bollywood", getString(R.string.Varun), cover[14]);
        clansList.add(a);

        a = new Clans("Vinoth Kannan", "FreeStyle/Bollywood", getString(R.string.Vinoth_Kannan), cover[15]);
        clansList.add(a);

        a = new Clans("Yogesh", "FreeStyle/Bollywood", getString(R.string.Yogesh), cover[16]);
        clansList.add(a);

        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
