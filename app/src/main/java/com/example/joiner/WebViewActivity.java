package com.example.joiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        web = (WebView) findViewById(R.id.mywebview);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.loadUrl("https://hackupc-typekit-playground.herokuapp.com/?surfaceId=connect&apiURL=https://joiner-app.glitch.me/installations/installationId?form_id=3");
    }
}