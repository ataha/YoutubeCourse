package com.ahmed.youtubecourse;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Ahmed on 7/24/2015.
 */
public class Menu extends ListActivity {

    String classes[] = {"Tabs", "MainActivity", "example2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override

    protected void onListItemClick(ListView l, View v, int position, long id) {


        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];
        try {
            Class ourClass = Class.forName("com.ahmed.youtubecourse." + cheese);
            Intent ourIntent = new Intent();
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
