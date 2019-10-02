package com.khusainov.rinat.activityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CatalogActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    public static final String SAVED_STRING = "SAVED_STRING";
    public static final String SAVED_PARCEL = "SAVED_PARCEL";

    private Button mButton;

    private TextView mFirstName;
    private TextView mCarModel;
    private TextView mLink;

    private TestModel mTestModel;
    private String first_name;
    private String car_model;
    private List<String> names;
    private List<String> cars;

    private List<String> namesFromParcel;
    private List<String> carsFromParcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        mFirstName = findViewById(R.id.tv_name);
        mCarModel = findViewById(R.id.tv_car);
        mButton = findViewById(R.id.btn_1);
        mButton.setOnClickListener(this::onClick);

        mLink = findViewById(R.id.tv_link);
        mLink.setText(Html.fromHtml("<a href='market://account'>Market Account</a>"));
        mLink.setMovementMethod(LinkMovementMethod.getInstance());
        mLink.setLinksClickable(true);

        generateModel();

        mFirstName.setText(first_name);
        mCarModel.setText(car_model);

        Uri data = getIntent().getData();
        Log.d(TAG, "onCreate: CatalogActivity");
        Log.d(TAG, "Deep link clicked: " + data);
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
        switch (view.getId()) {
            case R.id.btn_1:
                Intent intent = new Intent(this, MapActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putParcelable(SAVED_PARCEL, mTestModel);
        outState.putString(SAVED_STRING, first_name);
        Log.d(TAG, "onSaveInstanceState: SAVE");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        mTestModel = savedInstanceState.getParcelable(SAVED_PARCEL);
        first_name = savedInstanceState.getString(SAVED_STRING);
        mFirstName.setText(first_name);
        Log.d(TAG, "onRestoreInstanceState: RESTORE");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: CatalogActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: CatalogActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: CatalogActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: CatalogActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: CatalogActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: CatalogActivity");
    }
}
