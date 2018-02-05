package com.pma.viewmodel;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.widget.ImageView;

import com.pma.model.IMPORTANCE;
import com.pma.model.Reminder;

import java.util.Date;

/**
 * Created by tano on 5.2.2018 г..
 */

public class ReminderViewModel implements Observable {

    private final Reminder model;
    private PropertyChangeRegistry registry = new PropertyChangeRegistry();

    public ReminderViewModel(Reminder model) {
        this.model = model;
    }

    @Bindable
    public int getIconId() {
        return model.getIconId();
    }

    public void setIconId(int iconId) {
        model.setIconId(iconId);
    }

    @Bindable
    public String getTitle() {
        return model.getTitle();
    }

    public void setTitle(String title) {
        model.setTitle(title);
    }

    @Bindable
    public String getDescription() {
        return model.getDescription();
    }

    public void setDescription(String description) {
        model.setDescription(description);
    }

    @Bindable
    public int getDaysToLive() {
        return model.getDaysToLive();
    }

    public void setDaysToLive(int daysToLive) {
        model.setDaysToLive(daysToLive);
    }

    @Bindable
    public int getPerDay() {
        return model.getPerDay();
    }

    public void setPerDay(int perDay) {
        model.setPerDay(perDay);
    }

    @Bindable
    public Date getStart() {
        return model.getStart();
    }

    public void setStart(Date start) {
        model.setStart(start);
    }

    @Bindable
    public IMPORTANCE getImportance() {
        return model.getImportance();
    }

    public void setImportance(IMPORTANCE importance) {
        model.setImportance(importance);
    }

    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        registry.add(onPropertyChangedCallback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        registry.remove(onPropertyChangedCallback);
    }
}
