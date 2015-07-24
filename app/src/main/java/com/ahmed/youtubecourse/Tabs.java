package com.ahmed.youtubecourse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


public class Tabs extends Activity implements View.OnClickListener {

    TabHost th;
    TextView showResults;
    long start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
        th = (TabHost) findViewById(R.id.tabHost);
        Button newTab = (Button) findViewById(R.id.bAddTab);
        Button bStart = (Button) findViewById(R.id.bStart);
        Button bStop = (Button) findViewById(R.id.bStop);
        showResults = (TextView) findViewById(R.id.tvShowResults);

        newTab.setOnClickListener(this);
        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);

        th.setup();
        TabSpec specs = th.newTabSpec("tag1");
        specs.setContent(R.id.tab1);
        specs.setIndicator("StopWatch");
        th.addTab(specs);

        specs = th.newTabSpec("tag2");
        specs.setContent(R.id.tab2);
        specs.setIndicator("Tab 2");
        th.addTab(specs);


        specs = th.newTabSpec("tag3");
        specs.setContent(R.id.tab3);
        specs.setIndicator("Add new Tab");
        th.addTab(specs);

        start = 0;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bAddTab:
                TabSpec ourSpec = th.newTabSpec("tag1");
                ourSpec.setContent(new TabHost.TabContentFactory() {

                    @Override
                    public View createTabContent(String tag) {

                        TextView text = new TextView(Tabs.this);
                        text.setText("You`ve created a new Tab");
                        return (text);
                    }
                });

                ourSpec.setIndicator("New Tab");
                th.addTab(ourSpec);

                break;

            case R.id.bStart:
                start = System.currentTimeMillis();
                break;

            case R.id.bStop:
                stop = System.currentTimeMillis();
                if (start != 0) {
                    long results = stop - start;
                    int millis = (int) results;
                    int second = (int) results / 1000;
                    int minutes = second / 60;
                    millis = millis % 100;
                    second = second % 60;

                    showResults.setText(String.format("%d:%02d:%02d", minutes, second, millis));
                }
                break;
        }
    }
}
