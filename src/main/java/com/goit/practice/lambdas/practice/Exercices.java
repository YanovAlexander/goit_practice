package com.goit.practice.lambdas.practice;

public class Exercices {
    /*TODO Задача №1*/
    //Конвертировать елементы коллекции в аппер кейс
    //Input Parameters
    // List<String> collection = asList("My", "name", "is", "John", "Doe");
    //Expected result
    // List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
    //asList("");
    //asList("trarara", "uasudasu");

    /*TODO Задача №2*/
    //Отфильтровать коллекцию так, что бы только получить елементы длина которых меньше 4 символов
    //Input Parameters
    // List<String> collection = asList("My", "name", "is", "John", "Doe");
    //Expected result
    // List<String> expected = asList("My", "is", "Doe");


    /*TODO Задача №3*/
    //Обьединить два списка в один!
    //Input Parameters
    // List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
    //Expected result
    // List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");


    /*TODO Задача №4*/
    //Получить самого старого сотрудника с коллекции
    //Input Parameters
    // Employee sara = new Employee("Sara", 45);
    // Employee viktor = new Employee("Viktor", 40);
    // Employee eva = new Employee("Eva", 42);
    //List<Employee> collection = asList(sara, eva, viktor);
    //Expected result
    // Eva is the oldest person

    /*TODO Задача№5*/
    //Суммировать все елементы коллекции
    //Input Parameters
    //List<Integer> numbers = asList(1, 2, 3, 4, 5);
    //Expected result
    //15


    /*TODO Задача №6*/
    //Получить имена всех людей, которым меньше 25 лет
    //Input parameters
    // Employee sara = new Employee("Sara", 19);
    //        Employee viktor = new Employee("Viktor", 40);
    //        Employee eva = new Employee("Eva", 42);
    //        Employee anna = new Employee("Anna", 20);
    //        List<Employee> collection = asList(sara, eva, viktor, anna);
    //Expected result
    //[Sara, Anna]



    /*TODO Задача №7*/
    //Get people statistics: average age, count, maximum age, minimum age and sum og all ages.
    //Получить статистику по людям: средний возраст, подсчитать колличество людей, максимальный возраст, минимальный возраст, суммировать все возраста
    //Input parameters
    //Employee sara = new Employee("Sara", 44);
    //    Employee viktor = new Employee("Viktor", 40);
    //    Employee eva = new Employee("Eva", 42);
    //    List<Employee> collection = asList(sara, eva, viktor);
    //IntStream summaryStatistics

    /*TODO Задача №8*/
    //Группировать людей по национальности
    //Input parameters
    // Employee sara = new Employee("Sara", 4, "Norwegian");
    // Employee viktor = new Employee("Viktor", 40, "Serbian");
    // Employee eva = new Employee("Eva", 42, "Norwegian");


    /*TODO Задача №9*/
    //Вернуть имена людей разделив их запятой
    //Input parameters
    // Employee sara = new Employee("Sara", 4);
    //        Employee viktor = new Employee("Viktor", 40);
    //        Employee eva = new Employee("Eva", 42);
    //        List<Employee> collection = asList(sara, viktor, eva);
    //Expected result
    //Names: Sara, Viktor, Eva.


    //Как вы думаете сколько операций будет сделано в данном примере? 4???
    //Employee employee = Stream.of(empIds)
    //      .map(employeeRepository::findById)
    //      .filter(e -> e != null)
    //      .filter(e -> e.getSalary() > 100000)
    //      .findFirst()
    //      .orElse(null);

}
