package com.goit.practice.http.practice;

import com.goit.practice.http.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpClient11Util {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static <T extends User> List<User> sendGetWithListResponse(String url, Class<T> valueType) throws IOException, InterruptedException {
        HttpResponse<String> response = executeGet(url);
        return JsonUtil.readListValue(response.body(), valueType);
    }

    public static <T extends User> T sendGet(String url, Class<T> valueType) throws IOException, InterruptedException {
        HttpResponse<String> response = executeGet(url);
        return JsonUtil.readValue(response.body(), valueType);
    }

    public static <T extends User> T sendPost(String url, T body, Class<T> valueType) throws IOException, InterruptedException {
        HttpResponse<String> response = CLIENT.send(HttpRequest.newBuilder()
                .header("Content-type", "application/json")
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.writeValueAsString(body)))
                .build(), HttpResponse.BodyHandlers.ofString());

        return JsonUtil.readValue(response.body(), valueType);
    }

    public static <T extends User> T sendPut(String url, T body, Class<T> valueType) throws IOException, InterruptedException {
        HttpResponse<String> response = CLIENT.send(HttpRequest.newBuilder()
                .header("Content-type", "application/json")
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofString(JsonUtil.writeValueAsString(body)))
                .build(), HttpResponse.BodyHandlers.ofString());

        return JsonUtil.readValue(response.body(), valueType);
    }

    public static <T extends User> boolean sendDelete(String url, T body, Class<T> valueType) throws IOException, InterruptedException {
        HttpResponse<String> response = CLIENT.send(HttpRequest.newBuilder()
                .header("Content-type", "application/json")
                .uri(URI.create(url))
                .method("DELETE", HttpRequest.BodyPublishers.ofString(JsonUtil.writeValueAsString(body)))
                .build(), HttpResponse.BodyHandlers.ofString());

        return Boolean.parseBoolean(response.body());
    }

    private static HttpResponse<String> executeGet(String url) throws IOException, InterruptedException {
        return CLIENT.send(HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString());
    }
}
