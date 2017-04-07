package com.example.android.hyderabadtourguide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pallavi J on 02-04-2017.
 */

public class TouristLocation implements Parcelable{
    private static final int NO_SRC_PROVIDED = -1;
    private String mName="";
    private String mDescription="";
    private double mLongitude=NO_SRC_PROVIDED;
    private double mLatitude=NO_SRC_PROVIDED;
    private String mContactNumber ="";
    private String mVistingHours="";
    private String mTicketInfo="";
    private int mImageResrc = NO_SRC_PROVIDED;

    public TouristLocation(Parcel in ) {
        mName         = in.readString();
        mDescription  = in.readString();
        mLatitude     = in.readDouble();
        mLongitude    = in.readDouble();
        mContactNumber= in.readString();
        mVistingHours = in.readString();
        mTicketInfo   = in.readString();
        mImageResrc   = in.readInt();
    }
    public int describeContents() {
        return 0;
    }
    public static final Parcelable.Creator<TouristLocation> CREATOR = new Parcelable.Creator<TouristLocation>() {
        public TouristLocation createFromParcel(Parcel in ) {
            return new TouristLocation( in );
        }

        public TouristLocation[] newArray(int size) {
            return new TouristLocation[size];
        }
    };


    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeDouble(mLatitude);
        dest.writeDouble(mLongitude);
        dest.writeString(mContactNumber);
        dest.writeString(mVistingHours);
        dest.writeString(mTicketInfo);
        dest.writeInt(mImageResrc);
    }


    public TouristLocation(String name, int imageResrc,  double latitude, double longitude, String vistingHours, String ticketInfo,String contactNumber, String description) {
        this.mName = name;
        this.mDescription = description;
        this.mContactNumber = contactNumber;
        this.mVistingHours = vistingHours;
        this.mTicketInfo = ticketInfo;
        this.mLongitude = longitude;
        this.mLatitude = latitude;
        this.mImageResrc = imageResrc;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public String getContactNumber() {
        return mContactNumber;
    }

    public String getVistingHours() {
        return mVistingHours;
    }

    public String getTicketInfo() {
        return mTicketInfo;
    }

    public int getImageResrc() {
        return mImageResrc;
    }

    @Override
    public String toString() {
        return "TouristLocation{" +
                "mName='" + mName + '\'' +
               // ", mDescription='" + mDescription + '\'' +
                ", mLongitude=" + mLongitude +
                ", mLatitude=" + mLatitude +
                ", mContactNumber='" + mContactNumber + '\'' +
                ", mVistingHours='" + mVistingHours + '\'' +
                ", mTicketInfo='" + mTicketInfo + '\'' +
                ", mImageResrc=" + mImageResrc +
                '}';
    }


    public boolean hasLocation(){
        return (mLatitude != NO_SRC_PROVIDED && mLongitude !=NO_SRC_PROVIDED) ;
    }
}
