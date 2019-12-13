package com.goit.practice.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws Exception {
//        javaDefault();
//        getRequest();
//        postRequest();
        getWithQuery();
    }

    private static void getRequest() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://pingponggoit.herokuapp.com/sendMessage")
                .get()
                .build();
        Response response = client.newCall(request).execute();

        String headers = response.headers().toString();
        String body = new String(response.body().bytes());
        System.out.println("Headers: " + headers);
        System.out.println("Headers general: " + response.networkResponse());
        System.out.println("Body: " + body);
    }


    private static void postRequest() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(new Request.Builder()
                .url("https://pingponggoit.herokuapp.com/sendMessage")
                .post(RequestBody.create(MediaType.parse("applciation/json"), "New message"))
                .build()).execute();
        System.out.println(new String(response.body().bytes()));
    }

    private static void getWithQuery() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(new Request.Builder()
                .get()
                .url("https://pingponggoit.herokuapp.com/getUser?name=Oleksandr&surname=Yanov&salary=12121&gender=male")
                .build()).execute();
        ObjectMapper mapper = new ObjectMapper();
        String string = new String(response.body().bytes());
        User user = null;
        user = mapper.readValue(string, User.class);
        System.out.println(user);
    }

    private static void javaDefault() throws IOException {
        URL url = new URL("https://pingponggoit.herokuapp.com/");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedStream = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer buffer = new StringBuffer();
        String response;
        while ((response = bufferedStream.readLine()) != null) {
            buffer.append(response);
        }
        System.out.println(buffer.toString());
    }
}
