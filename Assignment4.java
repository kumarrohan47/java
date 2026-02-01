
// Assignment 4: Java Streams & Lambda Expressions

// Restrictions:
// No loops (for, while)
// No external libraries
// Use Streams & Lambda expressions

import java.util.*;
import java.util.stream.Collectors;

// Given Model Class
class Employee {
    int id;
    String name;
    String dept;
    int salary;
    List<String> skills;

    Employee(int id, String name, String dept, int salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return name + " | " + dept + " | " + salary;
    }
}

public class Assignment4 {

    public static void main(String[] args) {
        // Sample Data
        List<Employee> employees = List.of(
            new Employee(1, "Aman", "IT", 70000, List.of("Java", "Spring")),
            new Employee(2, "Ravi", "HR", 40000, List.of("Recruitment")),
            new Employee(3, "Neha", "IT", 90000, List.of("Java", "Docker")),
            new Employee(4, "Pooja", "Finance", 60000, List.of("Excel", "Accounts")),
            new Employee(5, "Aman", "IT", 70000, List.of("Java", "Spring"))
        );

        // Task implementations
        System.out.println("Task 1: " + task1(employees));
        System.out.println("Task 2: " + task2(employees));
        System.out.println("Task 3: " + task3(employees));
        System.out.println("Task 4: " + task4(employees));
        System.out.println("Task 5: " + task5(employees));
        System.out.println("Task 6: " + task6(employees));
        System.out.println("Task 7: " + task7(employees));
        System.out.println("Task 8: " + task8(employees));
        System.out.println("Task 9: " + task9(employees));
        System.out.println("Task 10: " + task10(employees));
        System.out.println("Task 11: " + task11(employees));
        System.out.println("Task 12: " + task12(employees));
    }

    // Task 1: Filter
    // Find all employees whose salary > 60,000.
    // Output: List<Employee>
    static List<Employee> task1(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.salary > 60000)
                .toList();
    }

    // Task 2: Map
    // Extract only employee names.
    // Output: List<String>
    static List<String> task2(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.name)
                .toList();
    }

    // Task 3: Distinct
    // Find all unique employee names.
    // Output: Set<String> or List<String>
    static Set<String> task3(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.name)
                .collect(Collectors.toSet());
    }

    // Task 4: Sorting
    // Sort employees by salary (descending).
    // Output: List<Employee>
    static List<Employee> task4(List<Employee> employees) {
        return employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.salary, e1.salary))
                .toList();
    }

    // Task 5: Skip + Limit
    // Find 2nd and 3rd highest paid employees.
    // ➡ Hint: sorted → skip → limit
    static List<Employee> task5(List<Employee> employees) {
        return employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.salary, e1.salary))
                .skip(1)
                .limit(2)
                .toList();
    }

    // Task 6: flatMap
    // Extract all unique skills across employees.
    // Output: Set<String>
    static Set<String> task6(List<Employee> employees) {
        return employees.stream()
                .flatMap(e -> e.skills.stream())
                .collect(Collectors.toSet());
    }

    // Task 7: Reduce
    // Calculate total salary of all employees using reduce().
    // Output: int
    static int task7(List<Employee> employees) {
        return employees.stream()
                .mapToInt(e -> e.salary)
                .reduce(0, Integer::sum);
    }

    // Task 8: Average Salary
    // Find average salary using:
    // map
    // reduce
    // count
    // Output: double
    static double task8(List<Employee> employees) {
        int sum = employees.stream()
                .mapToInt(e -> e.salary)
                .reduce(0, Integer::sum);
        long count = employees.stream().count();
        return (double) sum / count;
    }

    // Task 9: groupingBy
    // Group employees by department.
    // Output:
    // Map<String, List<Employee>>
    static Map<String, List<Employee>> task9(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept));
    }

    // Task 10: groupingBy + Collector
    // Find highest paid employee in each department.
    // Output:
    // Map<String, Employee>
    // ⚠ Handle Optional properly.
    static Map<String, Employee> task10(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept,
                        Collectors.maxBy(Comparator.comparingInt(e -> e.salary))))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().orElse(null)
                ));
    }

    // Task 11: Top Skilled High Earners
    // Create a single stream pipeline to:
    // Filter IT department
    // Salary > 60,000
    // Extract skills
    // Remove duplicates
    // Sort alphabetically
    // Return top 3 skills
    // Must use:
    // filter → flatMap → distinct → sorted → limit
    // Output: List<String>
    static List<String> task11(List<Employee> employees) {
        return employees.stream()
                .filter(e -> "IT".equals(e.dept))
                .filter(e -> e.salary > 60000)
                .flatMap(e -> e.skills.stream())
                .distinct()
                .sorted()
                .limit(3)
                .toList();
    }

    // Task 12: Department Salary Report (Complex)
    // For each department, compute:
    // Total salary
    // Average salary
    // Employee count
    // Output:
    // Map<String, Map<String, Double>>
    // Example:
    // {
    //   IT = { total=230000, average=76666.67, count=3 },
    //   HR = { total=40000, average=40000, count=1 }
    // }
    // ⚠ Must use:
    // groupingBy
    // reduce
    // collectingAndThen
    static Map<String, Map<String, Double>> task12(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    int total = list.stream().mapToInt(e -> e.salary).sum();
                                    double average = (double) total / list.size();
                                    double count = list.size();
                                    Map<String, Double> stats = new HashMap<>();
                                    stats.put("total", (double) total);
                                    stats.put("average", average);
                                    stats.put("count", count);
                                    return stats;
                                }
                        )));
    }
}

