package com.pma.viewmodel;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pma.R;
import com.pma.ReminderActivity;
import com.pma.databinding.ReminderBinding;
import com.pma.model.IMPORTANCE;
import com.pma.model.Reminder;
import com.pma.view.ListViewAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by tano on 2.2.2018 г..
 */

public final class MainViewModel {
    private AppCompatActivity context;
    private ObservableArrayList<Reminder> items;

    public MainViewModel(AppCompatActivity context) {
        this.context = context;
        items = new ObservableArrayList<>();
        items.addAll(getReminders());
    }

    private Collection<Reminder> getReminders() {
        List<Reminder> reminders = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            reminders.add(new Reminder(R.drawable.ic_launcher, "item " + i, "description " + i, 0, 0, new Date(), IMPORTANCE.HIGH));
        }

        return reminders;
    }

    public ObservableArrayList<Reminder> getItems() {
        return items;
    }

    @BindingAdapter("items")
    public static void bindList(ListView view, final List<Reminder> list) {
        view.setAdapter(new ListViewAdapter<Reminder>(list) {
            @Override
            protected ViewDataBinding bind(int position, ViewGroup parent) {
                ReminderBinding binding = DataBindingUtil.inflate(inflater, R.layout.reminder, parent, false);
                binding.setData(list.get(position));
                return binding;
            }
        });
    }

    public void startReminderActivity(View view) {
        Intent intent = new Intent(context, ReminderActivity.class);
        intent.putExtra(Reminder.class.getCanonicalName(), -1);
        context.startActivity(intent);
    }
}
