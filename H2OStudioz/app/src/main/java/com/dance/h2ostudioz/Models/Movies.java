package com.dance.h2ostudioz.Models;

/**
 * Created by aman on 9/9/17.
 */

public class Movies {

    private DayOfTheWeek dayOfTheWeek;
    private String description;
    public static int DESC_CHILD =0;
    public static int DOW_CHILD =1;
    public static int DOW =2;

    private int CHILD_TYPE;

    public DayOfTheWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public int getCHILD_TYPE() {
        return CHILD_TYPE;
    }

    public void setCHILD_TYPE(int CHILD_TYPE) {
        this.CHILD_TYPE = CHILD_TYPE;
    }

    public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
