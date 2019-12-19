package com.goit.practice.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;

public class Main {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String APP_URL = "https://pingponggoit.herokuapp.com/";
    private static final String GET_USER_URL = String.format("%s%s", APP_URL, "getUser");
    private static final String QUERY_PARAMS = "name=Oleksandr&surname=Yanov&salary=12121&gender=male";
    private static final String SEND_MESSAGE_URL = String.format("%s/%s", APP_URL, "sendMessage");
    private static final String SEND_MESSAGE_CONTENT = "New message";
    private static final String REQUEST_METHOD_GET = "GET";


    public static void main(String[] args) throws Exception {
//        javaDefault();
//        getRequest();
        postRequest1();
//        getWithQuery();
    }

    private static void getRequest() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://pingponggoit.herokuapp.com/")
                .get()
                .build();
        Response response = client.newCall(request).execute();

        String headers = response.headers().toString();
        Response networkResponse = response.networkResponse();
        String body = new String(Objects.requireNonNull(response.body()).bytes());

        System.out.println("Headers: " + headers);
        System.out.println("Headers general: " + networkResponse);
        System.out.println("Body: " + body);

        //CLOSE THE RESPONSE BODY
        //FROM OKHTTP -> Response bodies must be {@linkplain ResponseBody closed} and may
        //be consumed only once.
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
    }


    private static void postRequest() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(new Request.Builder()
                .url(SEND_MESSAGE_URL)
                .post(RequestBody.create(JSON, SEND_MESSAGE_CONTENT))
                .build()).execute();
        System.out.println(new String(Objects.requireNonNull(response.body()).bytes()));
        //CLOSE THE RESPONSE BODY
        //FROM OKHTTP -> Response bodies must be {@linkplain ResponseBody closed} and may
        //be consumed only once.
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
    }

    private static void postRequest1() throws IOException {
        OkHttpClient client = new OkHttpClient();
        User user = new User();
        user.setGender("male");
        user.setName("Alex");
        user.setSurname("Yanov");
        user.setSalary(100);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);
        Response response = client.newCall(new Request.Builder()
                .url(SEND_MESSAGE_URL)
                .post(RequestBody.create(JSON, s))
                .build()).execute();
        System.out.println(new String(Objects.requireNonNull(response.body()).bytes()));
        //CLOSE THE RESPONSE BODY
        //FROM OKHTTP -> Response bodies must be {@linkplain ResponseBody closed} and may
        //be consumed only once.
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
    }

    private static void getWithQuery() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(new Request.Builder()
                .get()
                .url(String.format("%s?%s", GET_USER_URL, QUERY_PARAMS))
                .build()).execute();
        User user = mapUserFromResponse(response);
        System.out.println("User name is " + user.getName());
        //CLOSE THE RESPONSE BODY
        //FROM OKHTTP -> Response bodies must be {@linkplain ResponseBody closed} and may
        //be consumed only once.
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
    }

    private static User mapUserFromResponse(Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String string = new String(Objects.requireNonNull(response.body()).bytes());
        return mapper.readValue(string, User.class);
    }

    private static void javaDefault() throws IOException {
        URL url = new URL(APP_URL);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod(REQUEST_METHOD_GET);
        StringBuffer buffer = new StringBuffer();
        try (InputStream inputStream = urlConnection.getInputStream();
             BufferedReader bufferedStream = new BufferedReader(new InputStreamReader(inputStream))) {
            readResponse(buffer, bufferedStream);
        }
        System.out.println(buffer.toString());
    }

    private static void readResponse(StringBuffer buffer, BufferedReader bufferedStream) throws IOException {
        String response;
        while ((response = bufferedStream.readLine()) != null) {
            buffer.append(response);
        }
    }
}
