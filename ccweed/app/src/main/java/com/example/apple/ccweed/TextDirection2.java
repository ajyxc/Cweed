package com.example.apple.ccweed;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by warrenchan on 2017-09-23.
 */

public class TextDirection2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.text_direction_layout2);

        MapsActivity hi = new MapsActivity();
        populateListView2();

    }

    public void populateListView2() {
        String[] myItems = {"1", "2", "3", "4"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.da_item,
                R.id.textView,
                myItems);
        ListView list = (ListView) findViewById(R.id.list2);
        list.setAdapter(adapter);

    }
}

