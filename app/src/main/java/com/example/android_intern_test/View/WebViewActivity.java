package com.example.android_intern_test.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.android_intern_test.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        web = findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String url = intent.getStringExtra(getString(R.string.url));
        String link = intent.getStringExtra(getString(R.string.links));
        if (url != null){
            web.loadUrl(url);
        } else {
            web.loadUrl(link);
        }


    }
}
