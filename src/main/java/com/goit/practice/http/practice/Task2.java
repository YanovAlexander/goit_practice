package com.goit.practice.http.practice;

import com.goit.practice.http.User;

import java.io.IOException;

public class Task2 {
    private static final String URL = "https://pingponggoit.herokuapp.com/getUserById?id=%s";

    public static void main(String[] args) {
        int idFromTask1 = 548;
//        okHttpClient(idFromTask1);
        javaClient(idFromTask1);
    }

    private static void javaClient(int idFromTask1) {
        try {
            final User user = HttpClient11Util.sendGet(String.format(URL, idFromTask1), User.class);
            System.out.println(user);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while sending get request " + e.getMessage());
        }
    }

    private static void okHttpClient(int idFromTask1) {
        try {
            User user = HttpUtil.sendGet(String.format(URL, idFromTask1), User.class);
            System.out.println("Got user with id " + user.getId());
        } catch (IOException e) {
            System.out.println("Error while sending get request " + e.getMessage());
        }
    }
}
