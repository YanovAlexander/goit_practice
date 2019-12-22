package com.goit.practice.lambdas.practice;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;

public class Task8 {
    public static void main(String[] args) {
        Employee sara = new Employee("Sara", 4, "Norwegian");
        Employee viktor = new Employee("Viktor", 40, "Serbian");
        Employee eva = new Employee("Eva", 42, "Norwegian");
        List<Employee> collection = asList(sara, eva, viktor);

        Map<String, List<Employee>> result = groupByNationality(collection);

        System.out.println("Norwegian's are " + result.get("Norwegian"));
    }

    private static Map<String, List<Employee>> groupByNationality(List<Employee> people) {
        return people.stream() // Convert collection to Stream
                .collect(groupingBy(Employee::getNationality)); // Group people by nationality
    }
}
