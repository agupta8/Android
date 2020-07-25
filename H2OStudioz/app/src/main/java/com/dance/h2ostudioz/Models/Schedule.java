package com.dance.h2ostudioz.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aman on 7/30/17.
 */

public class Schedule {
    @SerializedName("days")
    Day days = null;
    @SerializedName("danceForm")
    private String danceForm;
    @SerializedName("danceFormKey")
    private String danceFormKey;
    @SerializedName("desc")
    private String desc;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("updatedAt")
    private String updatedAt;
    @SerializedName("id")
    private String id;

    public Day getDays() {
        return days;
    }

    public void setDays(Day days) {
        this.days = days;
    }

    public String getDanceForm() {
        return danceForm;
    }

    public void setDanceForm(String danceForm) {
        this.danceForm = danceForm;
    }

    public String getDanceFormKey() {
        return danceFormKey;
    }

    public void setDanceFormKey(String danceFormKey) {
        this.danceFormKey = danceFormKey;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
