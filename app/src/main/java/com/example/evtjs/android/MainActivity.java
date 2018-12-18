package com.example.evtjs.android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);

        WebView webView = ((WebView) findViewById(R.id.webView));
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webView.addJavascriptInterface(new JSCallback(), "android");
        webView.loadUrl("file:///android_asset/index.html");
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.post(new Runnable() {
                    @SuppressLint("NewApi")
                    @Override
                    public void run() {
                        mWebView.loadUrl("javascript:createKeyPair()");
                    }
                });

            }
        });
    }

    class JSCallback {
        @JavascriptInterface

        public void get(String text){
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

        }
    }

}


