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
public class RestaurantsFragment extends Fragment {


    ArrayList<Item> arr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        arr = new ArrayList<Item>();
        arr.add(new Item("Ghazal Restaurant", R.drawable.ghazal_restaurant));
        arr.add(new Item("Shalimar Family Restaurant", R.drawable.shalimar_family_restaurant));
        arr.add(new Item("Swagath Restaurant and Bar", R.drawable.swagath_restaurant_and_bar));
        arr.add(new Item("Tawa Restaurant Panchkula", R.drawable.tawa_restaurant_panchkula));
        arr.add(new Item("Mainland China", R.drawable.mainland_china));
        arr.add(new Item("Kailash Restaurant", R.drawable.kailash_restaurant));

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
