package com.goit.practice.http.practice;

import com.goit.practice.http.User;

import java.io.IOException;

public class Task2 {
    private static final String URL = "https://pingponggoit.herokuapp.com/getUserById?id=%s";

    public static void main(String[] args) {
        int idFromTask1 = 230;
        try {
            User user = HttpUtil.sendGet(String.format(URL, idFromTask1), User.class);
            System.out.println("Got user with id " + user.getId());
        } catch (IOException e) {
            System.out.println("Error while sending get request " + e.getMessage());
        }
    }
}
