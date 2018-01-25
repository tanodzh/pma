package com.pma.com.pma.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pma.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by xworks.admin on 1/25/2018.
 */

public class RemindersViewAdapter extends RecyclerView.Adapter<RemindersViewAdapter.ReminderViewHolder> {

    private final LayoutInflater inflater;
    private List<RowItem> data = Collections.emptyList();

    public RemindersViewAdapter(Context context, List<RowItem> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override

    public ReminderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.reminder, parent, false);
        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReminderViewHolder holder, int position) {
        RowItem item = data.get(position);
        holder.icon.setImageResource(item.iconId);
        holder.title.setText(item.title);
        holder.description.setText(item.description);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ReminderViewHolder extends RecyclerView.ViewHolder {

        private final ImageView icon;
        private final TextView title;
        private final TextView description;

        public ReminderViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.reminder_icon);
            title = itemView.findViewById(R.id.reminder_title);
            description = itemView.findViewById(R.id.reminder_description);
        }
    }
}
