package com.example.dell.womensafetyapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;

/**
 * Created by DELL on 12-05-2018.
 */

public class TutorialListContent extends Fragment {

    public TutorialListContent() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tutorial_list, container, false);
        ArrayList<CustomList> lessonNames = new ArrayList<CustomList>();
        lessonNames.add(new CustomList("Lesson 1", R.drawable.red_button5));
        lessonNames.add(new CustomList("Lesson 2" ,R.drawable.red_button5));
        lessonNames.add(new CustomList("Lesson 3", R.drawable.red_button5));
       /* tours.add(new Tour(R.string.Columbia,R.string.SouthAmerica, R.drawable.columbia_southamerica));
        tours.add(new Tour(R.string.GreekIslands,R.string.Mynkonos, R.drawable.greekisland_mynkonos));
        tours.add(new Tour(R.string.Naheel_Tower,R.string.dubai, R.drawable.nakheeltower_dubai));
        tours.add(new Tour(R.string.Maldivies,R.string.Maldivies, R.drawable.maldives));
        tours.add(new Tour(R.string.Lefkas,R.string.greece, R.drawable.lefkas_greece));*/
        AdapterClass adapter = new AdapterClass(getActivity(), lessonNames);
        ListView listView = (ListView) rootView.findViewById(R.id.listoflessons);
        listView.setAdapter(adapter);
        return rootView;
    }
}

