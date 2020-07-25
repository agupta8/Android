package com.dance.h2ostudioz.Models;

/**
 * Created by aman on 9/9/17.
 */

import com.dance.h2ostudioz.Adapters.ParentListItem;

import java.util.List;

public class MovieCategory implements ParentListItem {
    private String mName;
    private String description;
    private List<Movies> mMovies;

    public MovieCategory(String name, List<Movies> movies) {
        mName = name;
        mMovies = movies;
    }

    public String getName() {
        return mName;
    }

    @Override
    public List<?> getChildItemList() {
        return mMovies;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
