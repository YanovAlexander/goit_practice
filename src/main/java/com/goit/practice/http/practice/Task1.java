package com.goit.practice.http.practice;

import com.goit.practice.http.User;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;

public class Task1 {
    private static final String URL = "https://pingponggoit.herokuapp.com/createUser";
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) {
        User user = new User.Builder().id(0)
                .name("Oleksandr")
                .surname("Yanov")
                .salary(19)
                .gender("male")
                .build();

        try {
            User resultUser = HttpUtil.sendPost(URL, RequestBody.create(JSON_MEDIA_TYPE, JsonUtil.writeValueAsString(user)),
                    User.class);
            System.out.println("User created with id " + resultUser.getId());
        } catch (IOException e) {
            System.out.println("Error while sending post request " + e.getMessage());
        }
    }
}
