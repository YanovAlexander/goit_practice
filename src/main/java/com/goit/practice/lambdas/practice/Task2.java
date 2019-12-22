package com.goit.practice.lambdas.practice;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Task2 {
    public static void main(String[] args) {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        List<String> result = collection.stream() // Convert collection to Stream
                .filter(value -> value.length() < 4) // Filter elements with length smaller than 4 characters
                .collect(toList());// Collect results to a new list
        System.out.println("Is collections equals? " + result.equals(expected));
    }
}
