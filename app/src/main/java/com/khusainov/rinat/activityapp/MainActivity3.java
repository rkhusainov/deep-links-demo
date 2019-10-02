package com.khusainov.rinat.activityapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private static final String TAG = "TAG";
    public Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        mButton = findViewById(R.id.btn_2);

        mButton.setOnClickListener(this::onClick);
        Log.d(TAG, "onCreate: MainActivity3");

        Uri data = getIntent().getData();
        Log.d(TAG, "Deep link clicked: "+ data);

    }

    private void onClick(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: MainActivity3");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: MainActivity3");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: MainActivity3");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: MainActivity3");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: MainActivity3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: MainActivity3");
    }
}