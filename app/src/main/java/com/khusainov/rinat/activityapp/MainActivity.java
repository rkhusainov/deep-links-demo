package com.khusainov.rinat.activityapp;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mCatalog;
    private TextView mMap;
    private TextView mSearch;
    private TextView mAccount;
    private TextView mHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHome = findViewById(R.id.tv_link_home);
        mHome.setText(Html.fromHtml("<a href='http://my.market.com'>Home</a>"));
        mHome.setMovementMethod(LinkMovementMethod.getInstance());
        mHome.setLinksClickable(true);

        mCatalog = findViewById(R.id.tv_link_catalog);
        mCatalog.setText(Html.fromHtml("<a href='http://my.market.com/catalog'>Catalog</a>"));
        mCatalog.setMovementMethod(LinkMovementMethod.getInstance());
        mCatalog.setLinksClickable(true);

        mMap = findViewById(R.id.tv_link_map);
        mMap.setText(Html.fromHtml("<a href='http://my.market.com/map'>Map</a>"));
        mMap.setMovementMethod(LinkMovementMethod.getInstance());
        mMap.setLinksClickable(true);

        mSearch = findViewById(R.id.tv_link_search);
        mSearch.setText(Html.fromHtml("<a href='http://my.market.com/search'>Search</a>"));
        mSearch.setMovementMethod(LinkMovementMethod.getInstance());
        mSearch.setLinksClickable(true);

        mAccount = findViewById(R.id.tv_link_account);
        mAccount.setText(Html.fromHtml("<a href='market://account'>Account</a>"));
        mAccount.setMovementMethod(LinkMovementMethod.getInstance());
        mAccount.setLinksClickable(true);
    }
}
