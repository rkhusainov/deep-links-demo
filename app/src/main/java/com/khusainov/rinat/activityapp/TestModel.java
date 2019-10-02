package com.khusainov.rinat.activityapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class TestModel implements Parcelable {

    private String name;
    private String car;

    private List<String> cities;
    private List<String> countries;


    public TestModel(String name, String car, List<String> cities, List<String> countries) {
        this.name = name;
        this.car = car;
        this.cities = cities;
        this.countries = countries;
    }

    protected TestModel() {
    }

    protected TestModel(Parcel in) {
        name = in.readString();
        car = in.readString();
        cities = in.createStringArrayList();
        countries = in.createStringArrayList();
    }

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            return new TestModel(in);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(car);
        dest.writeList(cities);
        dest.writeList(countries);
    }
}
