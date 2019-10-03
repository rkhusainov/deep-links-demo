package com.khusainov.rinat.activityapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    public static final String SAVED_PARCEL = "SAVED_PARCEL";

    public Button mButton;
    private TextView mFirstName;
    private TextView mCarModel;

    private TestModel mTestModel;
    private String first_name;
    private String car_model;
    private List<String> names;
    private List<String> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mFirstName = findViewById(R.id.tv_name);
        mCarModel = findViewById(R.id.tv_car);
        mButton = findViewById(R.id.btn_1);
        mButton.setOnClickListener(this::onClick);

        generateModel();

        mFirstName.setText(mTestModel.getName());
        mCarModel.setText(mTestModel.getCar());

        Log.d(TAG, "onCreate: SearchActivity");
        Uri data = getIntent().getData();
        Log.d(TAG, "Deep link clicked: "+ data);
    }

    private void generateModel() {
        names = Arrays.asList(getResources().getStringArray(R.array.names));
        Collections.shuffle(names);
        cars = Arrays.asList(getResources().getStringArray(R.array.cars));
        Collections.shuffle(cars);

        first_name = names.get(0);
        car_model = cars.get(0);

        mTestModel = new TestModel(first_name, car_model, names, cars);
    }

    private void onClick(View view) {
        Intent intent = new Intent(this, AccountActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_PARCEL, mTestModel);
        Log.d(TAG, "onSaveInstanceState: SAVE");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTestModel = savedInstanceState.getParcelable(SAVED_PARCEL);
        mFirstName.setText(mTestModel.getName());
        mCarModel.setText(mTestModel.getCar());
        Log.d(TAG, "onRestoreInstanceState: RESTORE");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: SearchActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: SearchActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: SearchActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: SearchActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: SearchActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: SearchActivity");
    }
}