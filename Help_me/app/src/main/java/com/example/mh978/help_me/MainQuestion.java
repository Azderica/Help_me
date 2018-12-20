package com.example.mh978.help_me;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.example.mh978.help_me.Law4.LegalTerm;

public class MainQuestion extends AppCompatActivity {
    private WebView mWebView;
    private String myUrl = "http://m.easylaw.go.kr/MOB/SearchEngineRetrieve.laf?mb_input=";      // 연결할 url
    String find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        find = intent.getStringExtra("item");
        myUrl = myUrl + find;
        myUrl = myUrl + "&ing=Y";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_question);

        mWebView = (WebView)findViewById(R.id.webquestionView);
        // 화면 사이즈 맞게 조절
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        // 줌 허용
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setSupportZoom(true);
        // 자바 스크립트처럼 사용
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.loadUrl(myUrl);
        mWebView.setWebViewClient(new WebViewClientClass());
    }

    // 해당 사이트 내에서 다른 곳으로 이동할 수 있게하는 함수
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
