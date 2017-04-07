package com.example.android.hyderabadtourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.example.android.hyderabadtourguide.R.id.imageView;

public class FullImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TouristLocation currLocation = (TouristLocation) getIntent().getParcelableExtra(getString(R.string.picKey));
        //Set Title
        setTitle(currLocation.getName());

        //Set the image of the Location
        ImageView fullImage = (ImageView) findViewById(imageView);
        // loading album cover using Glide library
        Glide.with(this).load(currLocation.getImageResrc()).centerCrop().into(fullImage);
    }


}
