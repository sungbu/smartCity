package com.example.smartcity.util;

import java.util.concurrent.CountDownLatch;

import okhttp3.RequestBody;

public class GetRequestResult {





    public static String result(final String url, final RequestBody requestBody) {
        final String[] result = {null};

        final CountDownLatch latch = new CountDownLatch(1);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                result[0] =RequestMessage.requestMessage(url,requestBody);

                try {
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            latch.await();
            thread.sleep(20);
            thread.interrupt();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result[0];
    }
}
