package com.ahmed.youtubecourse;

import android.app.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SharedPrefs extends Activity implements OnClickListener {

    EditText sharedData;
    TextView dataResults;
    public static String filename = "MySharedString";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedprefs);
        initialize();
        sharedPreferences = getSharedPreferences(filename, 0);
    }

    private void initialize() {

        Button save = (Button) findViewById(R.id.bSave);
        Button load = (Button) findViewById(R.id.bLoad);
        sharedData = (EditText) findViewById(R.id.edSharedPrefs);
        dataResults = (TextView) findViewById(R.id.tvShowResults);
        save.setOnClickListener(this);
        load.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bSave:

                String stringData = sharedData.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("sharedString", stringData);
                editor.commit();


                break;

            case R.id.bLoad:

                sharedPreferences = getSharedPreferences(filename, 0);
                String dataReturned = sharedPreferences.getString("sharedString", "Could not load");
                dataResults.setText(dataReturned);

                break;
        }

    }
}
