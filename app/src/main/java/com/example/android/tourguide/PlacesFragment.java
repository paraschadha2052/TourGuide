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

import java.util.ArrayList;

public class PlacesFragment extends Fragment {

    ArrayList<Item> arr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        arr = new ArrayList<Item>();
        arr.add(new Item("Rose Garden", R.drawable.rose_garden));
        arr.add(new Item("Sukhna Lake", R.drawable.sukhna_lake));
        arr.add(new Item("Rock Garden", R.drawable.rock_garden));
        arr.add(new Item("Art Gallery", R.drawable.govt_museum_art_gallery));
        arr.add(new Item("Fun City", R.drawable.fun_city));
        arr.add(new Item("Terrace Garden", R.drawable.terrace_garden));
        arr.add(new Item("Shanti Kunj Garden", R.drawable.shanti_kunj));

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
