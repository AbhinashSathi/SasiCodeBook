package com.example.sasicodebook;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {
    private WebView mywebView;

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("SetJavaScriptEnabled")
   // @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mywebView=(WebView) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://sasicodebook.000webhostapp.com/");
        WebSettings webSettings = mywebView.getSettings();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(0);
            mywebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mywebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            mywebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        webSettings.
                setJavaScriptEnabled(true);
    }
    public static class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    //@Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}