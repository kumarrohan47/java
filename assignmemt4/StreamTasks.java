import java.util.*;
import java.util.stream.*;

public class StreamTasks {

    static class Employee {
        int id;
        String name, dept;
        int salary;
        List<String> skills;

        Employee(int id, String name, String dept, int salary, List<String> skills) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
            this.skills = skills;
        }

        public String toString() {
            return name + " | " + dept + " | " + salary;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = List.of(
            new Employee(1,"Aman","IT",70000,List.of("Java","Spring")),
            new Employee(2,"Ravi","HR",40000,List.of("Recruitment")),
            new Employee(3,"Neha","IT",90000,List.of("Java","Docker")),
            new Employee(4,"Pooja","Finance",60000,List.of("Excel","Accounts")),
            new Employee(5,"Aman","IT",70000,List.of("Java","Spring"))
        );

        // Task examples (all constraints respected)

        employees.stream()
                .filter(e -> e.salary > 60000)
                .forEach(System.out::println);

        Set<String> skills = employees.stream()
                .flatMap(e -> e.skills.stream())
                .collect(Collectors.toSet());

        System.out.println(skills);
    }
}
