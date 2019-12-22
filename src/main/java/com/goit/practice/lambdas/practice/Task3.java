package com.goit.practice.lambdas.practice;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Task3 {
    public static void main(String[] args) {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        List<String> result = collection.stream() // Convert collection to Stream
                .flatMap(Collection::stream) // Replace list with stream
                .collect(toList());// Collect results to a new list
        System.out.println("Is collections equal? " + result.equals(expected));

    }
}
