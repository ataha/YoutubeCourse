package com.ahmed.youtubecourse;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by Ahmed on 8/1/2015.
 */
public class InternalData extends Activity implements View.OnClickListener {

    EditText sharedData;
    TextView dataResults;
    FileOutputStream fos;
    FileInputStream fis;
    String FILENAME = "InternalString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedprefs);
        initialize();
    }

    private void initialize() {

        Button save = (Button) findViewById(R.id.bSave);
        Button load = (Button) findViewById(R.id.bLoad);
        sharedData = (EditText) findViewById(R.id.edSharedPrefs);
        dataResults = (TextView) findViewById(R.id.tvLoadSharedPrefs);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bSave:
                String data = sharedData.getText().toString();
                //Saving data via file.
//                File f = new File(FILENAME);
//                try {
//                    fos = new FileOutputStream(f);
//                    fos.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                try {
                    fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;

            case R.id.bLoad:
                String collected = null;


                try {
                    fis = openFileInput(FILENAME);
                    byte[] dataArray = new byte[fis.available()];
                    while (fis.read(dataArray) != -1) {
                        collected = new String(dataArray);

                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fis.close();
                        dataResults.setText(collected);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                break;
        }

    }
}
