package com.example.android.hyderabadtourguide;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Pallavi J on 02-04-2017.
 */

public final class DataUtils {
    private final static int NAME_INDEX = 0, IMAGE_INDEX = 1, LATITUDE_INDEX = 2, LONGITUDE_INDEX = 3, TIMING_INDEX = 4,
            TICKET_INFO_INDEX =5, CONTACT_INDEX = 6, DESC_INDEX=7;
    /**
     * This method reads the input file and populate the Q & A ArrayList
     */
    public static ArrayList<TouristLocation> generateQList(Context context,String filename) {
        ArrayList<TouristLocation> locations = new ArrayList<TouristLocation>();
        // Change this position value if they is change in the input file format

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));
            // do reading, usually loop until end of file reading
            String mLine = reader.readLine();
            while (mLine != null) {
                String[] tokens = mLine.split(";");

                TouristLocation currLocation = new TouristLocation(
                        tokens[NAME_INDEX],
                        context.getResources().getIdentifier(tokens[IMAGE_INDEX], "drawable", context.getPackageName()),
                        Double.parseDouble(tokens[LATITUDE_INDEX]),
                        Double.parseDouble(tokens[LONGITUDE_INDEX]),
                        tokens[TIMING_INDEX],
                        tokens[TICKET_INFO_INDEX],
                        tokens[CONTACT_INDEX],
                        tokens[DESC_INDEX] );
                locations.add(currLocation);
                Log.i("Utils",currLocation.toString());
                mLine = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
}
