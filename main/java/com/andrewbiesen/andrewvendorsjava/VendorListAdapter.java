package com.andrewbiesen.andrewvendorsjava;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by matthew on 7/14/17.
 */

public class VendorListAdapter extends BaseAdapter {

    final LayoutInflater inflater;
    final List<Vendor> items;

    public VendorListAdapter(Context context, List<Vendor> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Vendor getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.items.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Vendor item = getItem(position);

        if(convertView == null) {
            // If convertView is null we have to inflate a new layout
            convertView = this.inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.displayText = ((TextView) convertView.findViewById(android.R.id.text1));
            convertView.setTag(viewHolder);
        }
        final ViewHolder viewHolder = (ViewHolder)convertView.getTag();
        viewHolder.displayText.setText(item.business);



        return convertView;
    }
}
