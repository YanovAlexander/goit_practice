package com.goit.practice.http.practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.goit.practice.http.User;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    private static final String CREATE_USER_URL = "https://pingponggoit.herokuapp.com/createUser";
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private static final String GET_USERS_URL = "https://pingponggoit.herokuapp.com/getUsers";
    private static final String REMOVE_USER = "https://pingponggoit.herokuapp.com/removeUser";

    public static void main(String[] args) {
        User user = new User.Builder().id(0)
                .name("Oleksandr")
                .surname("Yanov")
                .salary(19)
                .gender("male")
                .build();

        createUser(user);
        System.out.println("List of users before delete operation" + getUsers());
        removeUser(user);
        System.out.println("List of users after delete operation " + getUsers());
    }

    private static void removeUser(User user) {
        try {
            HttpUtil.sendDelete(REMOVE_USER, RequestBody.create(JSON_MEDIA_TYPE, JsonUtil.writeValueAsString(user)), Boolean.class);
        } catch (IOException e) {
            System.out.println("Error while sending delete request " + e.getMessage());
        }
    }

    private static void createUser(User user) {
        try {
            User resultUser = HttpUtil.sendPost(CREATE_USER_URL, RequestBody.create(JSON_MEDIA_TYPE, JsonUtil.writeValueAsString(user)),
                    User.class);
            System.out.println("User created with id " + resultUser.getId());
        } catch (IOException e) {
            System.out.println("Error while sending post request " + e.getMessage());
        }
    }

    private static List<User> getUsers() {
        try {
            return HttpUtil.sendGet(GET_USERS_URL, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            System.out.println("Error while sending get request " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
