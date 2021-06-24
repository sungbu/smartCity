package com.example.smartcity.util;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestMessage{

    public static String requestMessage(String url, RequestBody requestBody) {
        String result = null;

        OkHttpClient client = new OkHttpClient();

        Request request;

        if (requestBody == null) {
            request = new Request.Builder().url(url).build();
        } else {
            request = new Request.Builder().url(url).post(requestBody).build();
        }

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                result = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
