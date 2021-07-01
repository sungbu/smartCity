package com.example.smartcity.util;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.smartcity.Activity.FeedBackActivity;
import com.example.smartcity.Activity.PutMyDesActivity;
import com.example.smartcity.Activity.PutPasswordActivity;
import com.example.smartcity.MainActivity;

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
    @android.webkit.JavascriptInterface
    public void setListIndexEvent(String index) {
        Intent intent;
        switch (index){
            case "0": intent = new Intent(context, MainActivity.class); break;
            case "1": intent = new Intent(context, MainActivity.class); break;
            case "2": intent = new Intent(context, MainActivity.class); break;
            case "3": intent = new Intent(context, MainActivity.class); break;
            case "4": intent = new Intent(context, MainActivity.class); break;
            case "5": intent = new Intent(context, MainActivity.class); break;
            case "6": intent = new Intent(context, MainActivity.class); break;
            case "7": intent = new Intent(context, MainActivity.class); break;
            case "8": intent = new Intent(context, MainActivity.class); break;
            case "9": intent = new Intent(context, MainActivity.class); break;
            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }
        context.startActivity(intent);
    }

    @android.webkit.JavascriptInterface
    public void setHotIndexEvent(String index) {
        Intent intent;
        switch (index){
            case "0": intent = new Intent(context, MainActivity.class); break;
            case "1": intent = new Intent(context, MainActivity.class); break;
            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }
        context.startActivity(intent);
    }
    @android.webkit.JavascriptInterface
    public void setSearchBtnEvent(String searchValue) {
        Intent intent;
        if(searchValue.length() > 0){
            System.out.println(searchValue);
            intent = new Intent(context,MainActivity.class);
            context.startActivity(intent);
        }
    }
    @android.webkit.JavascriptInterface
    public void setListMenuIndexEvent(String index) {
        Intent intent;
        intent = new Intent(context, PutMyDesActivity.class);
        switch (index){
            case "0": intent = new Intent(context, PutMyDesActivity.class); break;
            case "1": intent = new Intent(context, PutMyDesActivity.class); break;
            case "2": intent = new Intent(context, PutPasswordActivity.class); break;
            case "3": intent = new Intent(context, FeedBackActivity.class); break;
            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }
        context.startActivity(intent);
    }
}
