package com.example.apple.ccweed;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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

        MapsActivity hi = new MapsActivity();
        populateListView();
    }

    public void populateListView() {

//        View v = null;
//        View currentFocus = getWindow().getCurrentFocus();
//        if (currentFocus != null)
//            v = currentFocus.getRootView();
//
//        String[] myItems = {};
//
//        switch (v.getId()) {
//            case R.id.lin1:
//                myItems = new String[]{"Go to Blue", "Go to Green", "Go to Purple", "Go to Red"};
//                break;
//            case R.id.lin2:
//                myItems = new String[]{"1", "2", "3", "4"};
//                break;
//        }

        String[] myItems = {"(1) Walk to WB Robson St FS Thurlow St. ", "(2) Take 005 towards 5 Robson. ", "(3) Take Car2Go to 845 Avison Way"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.da_item,
                R.id.textView,
                myItems);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);


    }
}

