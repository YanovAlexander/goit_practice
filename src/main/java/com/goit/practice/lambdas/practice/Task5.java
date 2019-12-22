package com.goit.practice.lambdas.practice;

import java.util.List;

import static java.util.Arrays.asList;

public class Task5 {
    public static void main(String[] args) {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        Integer sum = numbers.stream() // Convert collection to Stream
                .reduce(0, Integer::sum);
        System.out.println("Is sum is equal to 15? " + (sum == 15));
    }
}
