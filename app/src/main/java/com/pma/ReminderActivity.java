package com.pma;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pma.databinding.ActivityReminderBinding;
import com.pma.model.Reminder;
import com.pma.viewmodel.ReminderViewModel;

public class ReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        ActivityReminderBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_reminder);
        Long reminderId = getIntent().getLongExtra(Reminder.class.getCanonicalName(), -1);
        binding.setData(new ReminderViewModel(getReminder(reminderId)));
    }

    private Reminder getReminder(Long id) {
        //TODO: get it from database

        return new Reminder();
    }
}
