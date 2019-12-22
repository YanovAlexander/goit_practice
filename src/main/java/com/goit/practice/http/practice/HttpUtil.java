package com.goit.practice.http.practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.goit.practice.http.User;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class HttpUtil {
    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final String APP_URL = "https://pingponggoit.herokuapp.com/";

    public static <T extends User> List<User> sendGet(String url, TypeReference<List<User>> valueType) throws IOException {
        Response response = CLIENT.newCall(new Request.Builder()
                .get()
                .url(url)
                .build()).execute();
        List<User> result = JsonUtil.readValue(response.body().string(), valueType);
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
        return result;
    }

    public static <T extends User> T sendGet(String url, Class<T> valueType) throws IOException {
        Response response = CLIENT.newCall(new Request.Builder()
                .get()
                .url(url)
                .build()).execute();
        T result = JsonUtil.readValue(response.body().string(), valueType);
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
        return result;
    }

    public static <T extends User> T sendPost(String url, RequestBody body, Class<T> valueType) throws IOException {
        Response response = CLIENT.newCall(new Request.Builder()
                .post(body)
                .url(url)
                .build()).execute();
        T result = JsonUtil.readValue(response.body().string(), valueType);
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
        return result;
    }

    public static <T extends User> T sendPut(String url, RequestBody body, Class<T> valueType) throws IOException {
        Response response = CLIENT.newCall(new Request.Builder()
                .put(body)
                .url(url)
                .build()).execute();
        T result = JsonUtil.readValue(response.body().string(), valueType);
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
        return result;
    }

    public static <T> T sendDelete(String url, RequestBody body, Class<T> valueType) throws IOException {
        Response response = CLIENT.newCall(new Request.Builder()
                .delete(body)
                .url(url)
                .build()).execute();
        T result = JsonUtil.readValue(response.body().string(), valueType);
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
        return result;
    }
}
