package com.goit.practice.http.practice;

import com.goit.practice.http.User;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class HttpUtil {
    private static final OkHttpClient CLIENT = new OkHttpClient();

    public static <T extends User> List<User> sendGetWithListResponse(String url, Class<T> valueType) throws IOException {
        Response response = executeGet(url);
        List<User> result = JsonUtil.readListValue(response.body().string(), valueType);
        Optional.ofNullable(response.body()).ifPresent(ResponseBody::close);
        return result;
    }

    public static <T extends User> T sendGet(String url, Class<T> valueType) throws IOException {
        Response response = executeGet(url);
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

    private static Response executeGet(String url) throws IOException {
        return CLIENT.newCall(new Request.Builder()
                .get()
                .url(url)
                .build()).execute();
    }
}
