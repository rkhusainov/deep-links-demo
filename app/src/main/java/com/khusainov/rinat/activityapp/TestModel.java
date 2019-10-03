package com.khusainov.rinat.activityapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TestModel implements Parcelable {

    private String name;
    private String car;

    private List<String> names;
    private List<String> cars;


    public TestModel(String name, String car, List<String> cities, List<String> countries) {
        this.name = name;
        this.car = car;
        this.names = cities;
        this.cars = countries;
    }

    protected TestModel() {
    }

    protected TestModel(Parcel in) {
        name = in.readString();
        car = in.readString();
        names = in.createStringArrayList();
        cars = in.createStringArrayList();
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
        dest.writeList(names);
        dest.writeList(cars);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }
}
