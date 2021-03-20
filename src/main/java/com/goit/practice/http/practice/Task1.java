package com.goit.practice.http.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.goit.practice.http.User;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;

public class Task1 {
    private static final String URL = "https://pingponggoit.herokuapp.com/createUser";
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = new User.Builder().id(0)
                .name("Oleksandr")
                .surname("Yanov")
                .salary(19)
                .gender("male")
                .build();

//        okHttp(user);
        javaClient(user);
    }

    private static void javaClient(User user) throws IOException, InterruptedException {
        User resultUser = HttpClient11Util.sendPost(URL, user, User.class);
        System.out.println(resultUser);
    }

    private static void okHttp(User user) throws IOException {
        User resultUser = HttpUtil.sendPost(URL, RequestBody.create(JSON_MEDIA_TYPE, JsonUtil.writeValueAsString(user)),
                User.class);
        System.out.println("User created with id " + resultUser.getId());
    }
}
