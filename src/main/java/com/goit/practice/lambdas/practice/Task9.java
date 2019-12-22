package com.goit.practice.lambdas.practice;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public class Task9 {
    public static void main(String[] args) {
        Employee sara = new Employee("Sara", 4);
        Employee viktor = new Employee("Viktor", 40);
        Employee eva = new Employee("Eva", 42);
        List<Employee> collection = asList(sara, viktor, eva);
        String result = namesToString(collection);
        System.out.println("Is result is equal to 'Names: Sara, Viktor, Eva.'? " + result.equals("Names: Sara, Viktor, Eva."));
    }

    public static String namesToString(List<Employee> people) {
        return people.stream() // Convert collection to Stream
                .map(Employee::getName) // Map Person to name
                .collect(joining(", ", "Names: ", ".")); // Join names
    }
}
