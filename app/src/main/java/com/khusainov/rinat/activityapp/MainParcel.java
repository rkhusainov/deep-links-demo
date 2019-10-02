package com.khusainov.rinat.activityapp;

import android.os.Parcel;
import android.os.Parcelable;

class MainParcel implements Parcelable {

    protected MainParcel() {
    }

    protected MainParcel(Parcel in) {
    }

    public static final Creator<MainParcel> CREATOR = new Creator<MainParcel>() {
        @Override
        public MainParcel createFromParcel(Parcel in) {
            return new MainParcel(in);
        }

        @Override
        public MainParcel[] newArray(int size) {
            return new MainParcel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
