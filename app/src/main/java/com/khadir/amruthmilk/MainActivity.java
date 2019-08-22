package com.khadir.amruthmilk;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.os.Build;
import android.webkit.CookieManager;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        String appURL = "file:///android_asset/index.html";
//        String appURL = "https://in.yahoo.com/";
        WebView view = (WebView) this.findViewById(R.id.webView);
//        view.setWebChromeClient(new WebChromeClient());
        view.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //Log.println(Log.DEBUG, "HIGH", url);
                view.loadUrl(url);
                return true;
            }
        });
        view.clearCache(true);
        WebSettings webSettings = view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBlockNetworkImage(false);

        view.loadUrl(appURL);

    }
}
