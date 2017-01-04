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
public class BarsFragment extends Fragment {


    ArrayList<Item> arr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        arr = new ArrayList<Item>();
        arr.add(new Item("Sosha Cafe N Bar", R.drawable.sosha_cafe_and_bar));
        arr.add(new Item("Underdoggs Sports Bar", R.drawable.underdoggs_sports_bar_and_grill));
        arr.add(new Item("S Cafe and Bar", R.drawable.s_cafe_and_bar));
        arr.add(new Item("Satva", R.drawable.satva));
        arr.add(new Item("The Beer Cafe", R.drawable.the_beer_cafe));
        arr.add(new Item("The Great Beer", R.drawable.the_great_beer));

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
