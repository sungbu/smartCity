package com.example.smartcity.util;

import android.content.Context;

public class JavascriptInterface {
    Context context;
    public JavascriptInterface(Context c) {
        context = c;
    }

    @android.webkit.JavascriptInterface
    public String getNewsCategory() {
        String url = "http://124.93.196.45:10001/prod-api/press/category/list";

        String result = GetRequestResult.result(url, null);

        return result;
    }
    @android.webkit.JavascriptInterface
    public String getNewsList() {
        String url = "http://124.93.196.45:10001/prod-api/api/park/press/press/list";

        String result = GetRequestResult.result(url, null);

        return result;
    }
}
