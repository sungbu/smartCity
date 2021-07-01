package com.example.smartcity.Activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcity.R;
import com.example.smartcity.util.JavascriptInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PutMyDesActivity extends AppCompatActivity {


    @BindView(R.id.action_return_btn)
    ImageView actionReturnBtn;
    @BindView(R.id.aciton_title)
    TextView acitonTitle;
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_my_des);
        ButterKnife.bind(this);

        acitonTitle.setText("个人信息");
        actionReturnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/putMyDes.html");

        webView.addJavascriptInterface(new JavascriptInterface(getApplication()), "myDesPage");
    }
}