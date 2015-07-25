package com.ahmed.youtubecourse;

import android.app.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
        dataResults = (TextView) findViewById(R.id.tvLoadSharedPrefs);
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
                editor.apply();


                break;

            case  R.id.bLoad:
                Toast.makeText(this, "successfully loaded", Toast.LENGTH_LONG).show();

                sharedPreferences = getSharedPreferences(filename, 0);
                String loadedData = sharedPreferences.getString("sharedString", "Could not load data");
                dataResults.setText(loadedData);

                break;
        }

    }
}
