package com.example.android.tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CafeFragment extends Fragment {


    ArrayList<Item> arr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        arr = new ArrayList<Item>();
        arr.add(new Item("Cafe Coffee Day", R.drawable.cafe_coffee_day));
        arr.add(new Item("The Coffee Bean", R.drawable.the_coffee_bean_and_tea_leaf));
        arr.add(new Item("Back Packers Cafe", R.drawable.back_packers_cafe));
        arr.add(new Item("Mocha", R.drawable.mocha));
        arr.add(new Item("Barista", R.drawable.barista));

        ItemAdapter adapter = new ItemAdapter(getContext(), arr);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item it = arr.get(position);
                Uri uri = Uri.parse("http://www.google.com/#q="+it.getmName()+" Chandigarh");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return view;
    }

}
