package com.pma.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pma.R;
import com.pma.databinding.ReminderBinding;
import com.pma.model.Reminder;
import com.pma.view.ListViewAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tano on 2.2.2018 г..
 */

public class ContentViewModel implements Observable {
    private ObservableArrayList<ReminderViewModel> items;

    public ContentViewModel() {
        items = new ObservableArrayList<>();
        items.addAll(getReminders());
    }

    private Collection<ReminderViewModel> getReminders() {
        List<ReminderViewModel> data = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            data.add(new ReminderViewModel(new Reminder(R.drawable.ic_launcher, "item " + i, "description " + i)));
        }

        return data;
    }

    public ObservableArrayList<ReminderViewModel> getItems() {
        return items;
    }

    @BindingAdapter("items")
    public static void bindList(ListView view, ObservableArrayList<ReminderViewModel> list) {
        view.setAdapter(new ListViewAdapter<ReminderViewModel>(list) {
            @Override
            protected ViewDataBinding bind(int position, ViewGroup parent) {
                ReminderBinding binding = DataBindingUtil.inflate(inflater, R.layout.reminder, parent, false);
                binding.setData(list.get(position));
                return binding;
            }
        });
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {

    }
}
