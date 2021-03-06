package com.example.android.hyderabadtourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private LocationAdapter mLocationAdapter;


    public HistoricFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<TouristLocation> places = DataUtils.generateQList(getActivity(),getString(R.string.history_filename));;

        //Set the LocationAdapter passing the list valaues
        mLocationAdapter = new LocationAdapter(getActivity(),places);

        //Set the Gridlayout for the recyclerview
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.placesListView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        //attach the adapter and the recyclerview
        mRecyclerView.setAdapter(mLocationAdapter);

        return rootView;
    }
}
