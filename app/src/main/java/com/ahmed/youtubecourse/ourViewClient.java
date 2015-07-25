package com.ahmed.youtubecourse;


import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Ahmed on 7/25/2015.
 */
public class ourViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        return super.shouldOverrideUrlLoading(view, url);
        view.loadUrl(url);
        return true;
    }


}
