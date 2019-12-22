package com.goit.practice.lambdas.practice;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Task6 {
    public static void main(String[] args) {
        List<Employee> collection = asList(new Employee("Sara", 19),
                new Employee("Eva", 42),
                new Employee("Viktor", 40),
                new Employee("Anna", 20));

        List<String> result = getEmployeesOlderThan(collection, 25);

        System.out.println("Is result equal to [Sara, Anna]? " + result.toString().equals("[Sara, Anna]"));
    }

    private static List<String> getEmployeesOlderThan(List<Employee> collection, int age) {
        return collection.stream()
                    .filter(person -> person.getAge() < age) // Filter kids (under age of 18)
                    .map(Employee::getName) // Map Person elements to names
                    .collect(toList());
    }
}
