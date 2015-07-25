package com.ahmed.youtubecourse;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;


public class SimpleBrowser extends Activity implements OnClickListener {

    EditText url;
    WebView ourBrow;
    Button go;
    Button back;
    Button forward;
    Button refresh;
    Button history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        ourBrow = (WebView) findViewById(R.id.wvBrowser);

        ourBrow.getSettings().setJavaScriptEnabled(true);
        ourBrow.getSettings().setLoadWithOverviewMode(true);
        ourBrow.getSettings().setUseWideViewPort(true);
        ourBrow.getSettings().setBuiltInZoomControls(true);
        ourBrow.getSettings().setSupportZoom(true);
        ourBrow.getSettings().setDisplayZoomControls(true);
        ourBrow.zoomIn();
        ourBrow.zoomOut();

        ourBrow.setWebViewClient(new ourViewClient());

        try {
            ourBrow.loadUrl("http://www.youtube.com");
        } catch (Exception e) {
            e.printStackTrace();
        }

        initialize();

        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        history.setOnClickListener(this);

    }

    public void initialize() {
        go = (Button) findViewById(R.id.bGo);
        back = (Button) findViewById(R.id.bBack);
        forward = (Button) findViewById(R.id.bForward);
        refresh = (Button) findViewById(R.id.bRefresh);
        history = (Button) findViewById(R.id.bHistory);
        url = (EditText) findViewById(R.id.edURL);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bGo:

                String theWebSite = url.getText().toString();
//here to solve the site should be writen with http://
                if (!theWebSite.startsWith("www.") && !theWebSite.startsWith("http://")) {
                    theWebSite = "www." + theWebSite;
                }
                if (!theWebSite.startsWith("http://")) {
                    theWebSite = "http://" + theWebSite;
                }
//////////////////////////////////////////////////////////////////////////////////////
                ourBrow.loadUrl(theWebSite);

                //Hiding the keyboard after edit text
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(url.getWindowToken(), 0);

                break;
            case R.id.bBack:
                if (ourBrow.canGoBack())
                    ourBrow.goBack();

                break;
            case R.id.bForward:
                if (ourBrow.canGoForward())
                    ourBrow.goForward();

                break;
            case R.id.bRefresh:
                ourBrow.reload();

                break;
            case R.id.bHistory:
                ourBrow.clearHistory();

                break;
        }
    }

    //here how to destory the webview if went back from it.
    @Override
    protected void onDestroy() {

        if (ourBrow != null) {
            ourBrow.removeAllViews();
            ourBrow.destroy();
        }
        super.onDestroy();
    }
}
