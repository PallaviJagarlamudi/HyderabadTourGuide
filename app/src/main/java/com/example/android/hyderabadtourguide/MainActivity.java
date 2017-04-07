package com.example.android.hyderabadtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set onclickListener to show the Tourist places on clicking this button
        FloatingActionButton showMore = (FloatingActionButton) findViewById(R.id.showPlacesFAB);
        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TourAttractionsActivity.class);
                startActivity(i);
            }
        });

        //Set the banner
        ImageView toolbarBanner = (ImageView) findViewById(R.id.toolbarImage);
        Glide.with(this).load(R.drawable.hyderabad_banner).centerCrop().into(toolbarBanner);
    }
}
