package com.goit.practice.http.practice;

import okhttp3.*;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Task6 {
private static final OkHttpClient client = new OkHttpClient();
    public static void main(String[] args) {
        Call call = client.newCall(new Request.Builder().build());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Add logic to JavaFX application asynchronously.
            }

            @Override
            public void onFailure(Call call, IOException e) {
                //Add logic to handle exception
            }
        });
    }
}
