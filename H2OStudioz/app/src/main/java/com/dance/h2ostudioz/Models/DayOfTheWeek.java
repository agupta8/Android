package com.dance.h2ostudioz.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aman on 8/3/17.
 */

public class DayOfTheWeek implements Parcelable {
    String dayName;
    @SerializedName("morning")
    @Expose
    private List<String> morning = null;
    @SerializedName("evening")
    @Expose
    private List<String> evening = null;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("id")
    @Expose
    private String id;

    protected DayOfTheWeek(Parcel in) {
        dayName = in.readString();
        morning = in.createStringArrayList();
        evening = in.createStringArrayList();
        createdAt = in.readString();
        updatedAt = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dayName);
        dest.writeStringList(morning);
        dest.writeStringList(evening);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DayOfTheWeek> CREATOR = new Creator<DayOfTheWeek>() {
        @Override
        public DayOfTheWeek createFromParcel(Parcel in) {
            return new DayOfTheWeek(in);
        }

        @Override
        public DayOfTheWeek[] newArray(int size) {
            return new DayOfTheWeek[size];
        }
    };

    public List<String> getMorning() {
        return morning;
    }

    public void setMorning(List<String> morning) {
        this.morning = morning;
    }

    public List<String> getEvening() {
        return evening;
    }

    public void setEvening(List<String> evening) {
        this.evening = evening;
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

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
}
