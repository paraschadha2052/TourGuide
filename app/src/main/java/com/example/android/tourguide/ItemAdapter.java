package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paras on 1/5/17.
 */

public class ItemAdapter extends ArrayAdapter<Item>{


    public ItemAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        Item it = getItem(position);
        ImageView img = (ImageView) convertView.findViewById(R.id.image);
        TextView tx = (TextView) convertView.findViewById(R.id.name);

        img.setImageResource(it.getmImage());
        tx.setText(it.getmName());

        return convertView;
    }
}
