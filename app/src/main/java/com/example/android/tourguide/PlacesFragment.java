package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PlacesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        ArrayList<Item> arr = new ArrayList<Item>();
        arr.add(new Item("Rose Garden", R.drawable.rose_garden));
        arr.add(new Item("Rose Garden", R.drawable.rose_garden));

        ItemAdapter adapter = new ItemAdapter(getContext(), arr);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return view;
    }

}
