/**
 * Created by vedant on 28/6/16.
 */
package com.project;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetExample {
    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Some Error!";
    }
}

