package com.dance.h2ostudioz.Models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by aman on 8/4/17.
 */

public class GroupModel extends ExpandableGroup<DayOfTheWeek> {

    public GroupModel(String title, List<DayOfTheWeek> items) {
        super(title, items);
    }
}
