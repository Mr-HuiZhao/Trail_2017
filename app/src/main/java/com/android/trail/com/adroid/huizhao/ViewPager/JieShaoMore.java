package com.android.trail.com.adroid.huizhao.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.android.trail.R;

public class JieShaoMore extends AppCompatActivity {

    WebView show;
    private Button moreBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_shao_more);
        //获取页面中的button,webview组件
        moreBack = (Button)findViewById(R.id.more_back);
        show = (WebView)findViewById(R.id.more_show);

        WebSettings webSettings = show.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许运行JavaScript

        show.loadUrl("http://www.baidu.com");             //加载外网
        show.setWebViewClient(new HelloWebViewClient ());
        //webView.loadUrl("file:///android_asset/XX.html");   //本地网站

        moreBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(JieShaoMore.this,JieShaoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
