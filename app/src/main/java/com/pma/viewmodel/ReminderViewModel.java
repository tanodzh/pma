package com.pma.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.pma.model.Reminder;

/**
 * Created by tano on 3.2.2018 г..
 */

public class ReminderViewModel {

    private final Reminder model;

    public ReminderViewModel(Reminder model) {
        this.model = model;
    }

    public String getDescription() {

        return model.getDescription();
    }

    public String getTitle() {
        return model.getTitle();
    }

    public int getIconId() {

        return model.getIconId();
    }

    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
