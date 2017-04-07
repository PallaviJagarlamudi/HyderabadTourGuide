package com.example.android.hyderabadtourguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Pallavi J on 02-04-2017.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {
    private ArrayList<TouristLocation> mLocationList;
    private Context mContext;

    public LocationAdapter(Context context, ArrayList<TouristLocation> dataset) {
        this.mLocationList = dataset;
        this.mContext = context;
    }

    // Provide a reference to all the views for each data item in a view holder
    public class LocationViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView titleTextView;
        public ImageView coverImageView;

        public LocationViewHolder(View view) {
            super(view);
            mView = view ;
            titleTextView = (TextView) view.findViewById(R.id.nameOfPlace);
            coverImageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.places_list_item, parent, false);

                return new LocationViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final LocationViewHolder holder, int position) {
        // - get TouristLocation from your dataset at this position
        // - replace the contents of the view with that element
        final TouristLocation currLocation = mLocationList.get(position);
        holder.titleTextView.setText(currLocation.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(currLocation.getImageResrc()).into(holder.coverImageView);

        holder.mView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent mIntent = new Intent(mContext,LocationDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(mContext.getString(R.string.locObjectKey), currLocation);
                mIntent.putExtras(bundle);
                mContext.startActivity(mIntent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mLocationList.size();
    }
}
