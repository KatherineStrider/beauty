package com.example.kate.beautystyle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Kate on 26.04.2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private String[] strings;

    public ListViewAdapter(Context context, String[] strings){
        this.inflater = LayoutInflater.from(context);
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings == null ? 0 : strings.length;
    }

    @Override
    public Object getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.view_list, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.textType);
        name.setText(strings[position]);
        return convertView;
    }
}
