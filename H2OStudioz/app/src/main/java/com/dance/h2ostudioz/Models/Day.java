package com.dance.h2ostudioz.Models;

import java.util.List;

/**
 * Created by aman on 8/3/17.
 */

public class Day {

    List<DayOfTheWeek> dayOfTheWeeks;
//    @SerializedName("Monday")
//    private DayOfTheWeek monday;
//    @SerializedName("Tuesday")
//
//    private DayOfTheWeek tuesday;
//    @SerializedName("Wednesday")
//
//    private DayOfTheWeek wednesday;
//    @SerializedName("Thursday")
//
//    private DayOfTheWeek thursday;
//    @SerializedName("Friday")
//
//    private DayOfTheWeek friday;
//    @SerializedName("Saturday")
//    private DayOfTheWeek saturday;
//    @SerializedName("Sunday")
//    private DayOfTheWeek sunday;


    public List<DayOfTheWeek> getDayOfTheWeeks() {
        return dayOfTheWeeks;
    }

    public void setDayOfTheWeeks(List<DayOfTheWeek> dayOfTheWeeks) {
        this.dayOfTheWeeks = dayOfTheWeeks;
    }
}
