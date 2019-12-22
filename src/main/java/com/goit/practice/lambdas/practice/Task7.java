package com.goit.practice.lambdas.practice;

import java.util.IntSummaryStatistics;
import java.util.List;

import static java.util.Arrays.asList;

public class Task7 {
    public static void main(String[] args) {
        Employee viktor = new Employee("Viktor", 40);
        Employee eva = new Employee("Eva", 42);
        Employee sara = new Employee("Sara", 4);
        List<Employee> collection = asList(sara, eva, viktor);

        IntSummaryStatistics result = getStats(collection);

        System.out.println("Max age is " + result.getMax());
        System.out.println("Average age is " + result.getAverage());
    }

    private static IntSummaryStatistics getStats(List<Employee> people) {
        return people.stream()
                .mapToInt(Employee::getAge)
                .summaryStatistics();
    }
}
