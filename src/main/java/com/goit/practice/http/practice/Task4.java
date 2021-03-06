package com.goit.practice.http.practice;

import com.goit.practice.http.User;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    private static final String GET_USERS_URL = "https://pingponggoit.herokuapp.com/getUsers";
    private static final String OVERWRITE_URL = "https://pingponggoit.herokuapp.com/overwrite?id=%s";
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private static final String URL = "https://pingponggoit.herokuapp.com/getUserById?id=%s";

    public static void main(String[] args) {
        List<User> users = getUsers();
        User user = users.stream().findFirst().get();
        System.out.println("User before update " + user);

        user.setSalary(2001212);
        user.setName("Andrew");
        user.setSurname("Robertson");
//        updateUserOkHttpClient(user);
        updateUserJava11Client(user);

//        User updatedUser = getUserByIdOkHttp(user.getId());
        User updatedUser = getUserBytIdJava11Client(user.getId());
        System.out.println("Updated user " + updatedUser);
    }

    private static void updateUserJava11Client(User user) {
        try {
            HttpClient11Util.sendPut(String.format(OVERWRITE_URL, user.getId()), user, User.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while sending put request " + e.getMessage());
        }
    }

    private static User getUserBytIdJava11Client(int id) {
        try {
            return HttpClient11Util.sendGet(String.format(URL, id), User.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while sending get request " + e.getMessage());
        }
        return null;
    }

    private static User getUserByIdOkHttp(int id) {
        try {
            return HttpUtil.sendGet(String.format(URL, id), User.class);
        } catch (IOException e) {
            System.out.println("Error while sending get request " + e.getMessage());
        }
        return null;
    }

    private static void updateUserOkHttpClient(User user) {
        try {
            HttpUtil.sendPut(String.format(OVERWRITE_URL, user.getId()),
                    RequestBody.create(JSON_MEDIA_TYPE, JsonUtil.writeValueAsString(user)), User.class);
        } catch (IOException e) {
            System.out.println("Error while sending put request " + e.getMessage());
        }
    }

    private static List<User> getUsers() {
        try {
            return HttpUtil.sendGetWithListResponse(GET_USERS_URL, User.class);
        } catch (IOException e) {
            System.out.println("Error while sending get request " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
