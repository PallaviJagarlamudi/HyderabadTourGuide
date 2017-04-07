package com.example.android.hyderabadtourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.android.hyderabadtourguide.R.id.imageView;

public class LocationDetailActivity extends AppCompatActivity {

    private TouristLocation currLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Detail**","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        currLocation = (TouristLocation) getIntent().getParcelableExtra(getString(R.string.locObjectKey));

        //Set Title
        setTitle(currLocation.getName());

        //Set the image of the Location
        ImageView banner = (ImageView) findViewById(imageView);
        // loading album cover using Glide library
        Glide.with(this).load(currLocation.getImageResrc()).centerCrop().into(banner);
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imageIntent = new Intent(LocationDetailActivity.this, FullImageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(getString(R.string.picKey), currLocation);
                imageIntent.putExtras(bundle);
                startActivity(imageIntent);
            }
        });

        //Set the name of the location description
        TextView desciptionView = (TextView) findViewById(R.id.description);
        desciptionView.setText("\t\t\t"+currLocation.getDescription().replace("<p>","\n\n\t"));

        //Set the Visiting Hours if appalicable
        View buinessHourInfoContainer = (View) findViewById(R.id.timingsLayout);
        TextView buinessHourInfoView = (TextView) findViewById(R.id.timingsView);
        if (currLocation.getVistingHours().equals("")) {
            buinessHourInfoContainer.setVisibility(View.GONE);
        } else {
            buinessHourInfoContainer.setVisibility(View.VISIBLE);
            buinessHourInfoView.setText(currLocation.getVistingHours().replace("<n>","\n"));
        }

        //Set the entry ticket if applicable
        View ticketContainer = (View) findViewById(R.id.ticketLayout);
        TextView ticketView = (TextView) findViewById(R.id.ticketView);
        if (currLocation.getTicketInfo().equals("")) {
            ticketContainer.setVisibility(View.GONE);
        } else {
            ticketContainer.setVisibility(View.VISIBLE);
            ticketView.setText(currLocation.getTicketInfo().replace("<n>","\n"));
        }

        //Set the contact info
        View contactContainer = (View) findViewById(R.id.contactDetailsLayout);
        TextView contactView = (TextView) findViewById(R.id.contactView);
        if (currLocation.getContactNumber().equals("")) {
            contactContainer.setVisibility(View.GONE);
        } else {
            contactContainer.setVisibility(View.VISIBLE);
            contactView.setText(currLocation.getContactNumber());
        }

        //Set onclickListener to show the Tourist places on clicking this button
        FloatingActionButton showLocaion = (FloatingActionButton) findViewById(R.id.showLocationFAB);
        if(currLocation.hasLocation()){
            showLocaion.setVisibility(View.VISIBLE);
            showLocaion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double latitude = currLocation.getLatitude();
                    Double longitude = currLocation.getLongitude();
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("geo:0,0?z=17&q=<" + latitude  + ">,<" + longitude
                                    + ">(" + currLocation.getName() + ")"));
                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }
                }
            });
        }else{
            showLocaion.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
