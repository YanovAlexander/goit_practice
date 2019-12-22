package com.goit.practice.lambdas.practice;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class Task4 {
    public static void main(String[] args) {
        Employee sara = new Employee("Sara", 45);
        Employee viktor = new Employee("Viktor", 40);
        Employee eva = new Employee("Eva", 42);

        List<Employee> collection = asList(sara, eva, viktor);
        Employee result = collection.stream() // Convert collection to Stream
                .max(Comparator.comparing(Employee::getAge)) // Compares people ages
                .get();// Gets stream result
        System.out.println("Is result is equal to Eva and age 45? " + (result.getAge() == 45));

    }
}
