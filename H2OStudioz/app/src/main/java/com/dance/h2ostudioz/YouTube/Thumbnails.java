package com.dance.h2ostudioz.YouTube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aman on 8/19/17.
 */

public class Thumbnails {
    @SerializedName("default")
    @Expose
    private Size _default;
    @SerializedName("medium")
    @Expose
    private Size medium;
    @SerializedName("high")
    @Expose
    private Size high;

    public Size getDefault() {
        return _default;
    }

    public void setDefault(Size _default) {
        this._default = _default;
    }

    public Size getMedium() {
        return medium;
    }

    public void setMedium(Size medium) {
        this.medium = medium;
    }

    public Size getHigh() {
        return high;
    }

    public void setHigh(Size high) {
        this.high = high;
    }

}
