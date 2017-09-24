package com.example.apple.ccweed;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by warrenchan on 2017-09-23.
 */

public class TextDirection extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.text_direction_layout);

//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .enableAutoManage(this /* FragmentActivity */,
//                        this /* OnConnectionFailedListener */)
//                .addConnectionCallbacks(this)
//                .addApi(LocationServices.API)
//                .addApi(Places.GEO_DATA_API)
//                .addApi(Places.PLACE_DETECTION_API)
//                .build();
//        mGoogleApiClient.connect();
        MapsActivity hi = new MapsActivity();
        populateListView();

    }

    public void populateListView() {
        String[] myItems = {"Go to Blue", "Go to Green", "Go to Purple", "Go to Red"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.da_item,
                R.id.textView,
                myItems);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);



    }
}

