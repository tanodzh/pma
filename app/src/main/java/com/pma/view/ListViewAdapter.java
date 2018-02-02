package com.pma.view;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by tano on 2.2.2018 г..
 */

public abstract class ListViewAdapter<T> extends BaseAdapter {

    protected List<T> list;
    protected LayoutInflater inflater;

    public ListViewAdapter(List<T> data) {
        list = data;
    }

    protected abstract ViewDataBinding bind(int position, ViewGroup parent);

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        ViewDataBinding binding = bind(position, parent);
        return binding.getRoot();
    }
}
