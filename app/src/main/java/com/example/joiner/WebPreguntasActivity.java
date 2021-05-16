package com.example.joiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.HashMap;
import java.util.Map;

public class WebPreguntasActivity extends AppCompatActivity{
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long id = getIntent().getIntExtra("id", -1);
        setContentView(R.layout.activity_web_view);
        web = (WebView) findViewById(R.id.mywebview);
        web.setVerticalScrollBarEnabled(false);
        web.setHorizontalScrollBarEnabled(false);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        web.getSettings().setUserAgentString("Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3");
        web.loadUrl("https://hackupc-typekit-playground.herokuapp.com/?surfaceId=connect&apiURL=https://joiner-app.glitch.me/installations/installationId?form_id="+id);
    }
}
