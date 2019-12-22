package com.goit.practice.lambdas.practice;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Task1 {
    public static void main(String[] args) {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");

        List<String> result = collection.stream() // Convert collection to Stream
                .map(String::toUpperCase) // Convert each element to upper case
                .collect(toList());
        System.out.println("Is lists equal? " + result.equals(expected));
    }
}
