package com.pma.model;

/**
 * Created by tano on 2.2.2018 г..
 */

public class Reminder {

    private int iconId;
    private String title;
    private String description;

    public Reminder(int iconId, String title, String description) {
        this.iconId = iconId;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
