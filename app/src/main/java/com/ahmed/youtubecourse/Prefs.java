package com.ahmed.youtubecourse;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Ahmed on 7/24/2015.
 */
public class Prefs extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
