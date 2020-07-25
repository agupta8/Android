package com.dance.h2ostudioz.Models;

/**
 * Created by aman on 6/26/17.
 */

public class Clans {

    private String name, classes, description;
    private String thumbnail;

    public Clans(String name, String classes,String description, String thumbnail){
        this.name = name;
        this.classes = classes;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
