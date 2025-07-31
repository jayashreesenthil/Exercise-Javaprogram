package ExceriseCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class sortEmployee_salary {

        // Employee class to represent an employee with a name and a rating
        static class Employee {
            private String name;
            private int rating;
            private int salary;
            public Employee(String name, int rating, int salary) {
                this.name = name;
                this.rating = rating;
                this.salary = salary;
            }

            public String getName() {
                return name;
            }

            public int getRating() {
                return rating;
            }
            public int getSalary() {
                return salary;
            }

            @Override
            public String toString() {
                return "Employee{name='" + name + "', rating=" + rating + " ', salary=" + salary + "'}";
            }
        }

        public static void main(String[] args) {
            // 1. Create a list of employees
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee("Alice", 4, 100000));
            employees.add(new Employee("Bob", 2, 8000));
            employees.add(new Employee("Charlie", 5, 20000));
            employees.add(new Employee("David", 3,25000));
            employees.add(new Employee("Eve", 1, 3000));

            System.out.println("Original Employee List:");
            employees.forEach(System.out::println);

            // 2. Sort employees by rating in ascending order using Java 8 Streams
            List<Employee> sortedEmployeesAsc = employees.stream()
                    .sorted(Comparator.comparing(Employee::getRating))
                    .collect(Collectors.toList());

            System.out.println("\nEmployees Sorted by Rating (Ascending):");
            sortedEmployeesAsc.forEach(System.out::println);

             // 3. Sort employees by rating in descending order using Java 8 Streams
            List<Employee> sortedEmployeesDesc = employees.stream()
                    .sorted(Comparator.comparing(Employee::getRating).reversed())
                    .collect(Collectors.toList());

            System.out.println("\nEmployees Sorted by Rating (Descending):");
            sortedEmployeesDesc.forEach(System.out::println);

            // 4. Sort employees by rating, then by name (for ties)
            List<Employee> sortedEmployeesByRatingThenName = employees.stream()
                    .sorted(Comparator.comparing(Employee::getRating)
                            .thenComparing(Employee::getName))
                    .collect(Collectors.toList());

            System.out.println("\nEmployees Sorted by Rating (Ascending) then Name (Ascending):");
            sortedEmployeesByRatingThenName.forEach(System.out::println);
            System.out.println("------------------------------------");
            // --- 4. Find the Max Rating ---
            Optional<Employee> maxRatedEmployee = employees.stream()
                    .max(Comparator.comparingInt(Employee::getRating));

            maxRatedEmployee.ifPresent(emp -> System.out.println("Employee with Max Rating: " + emp));
            // You can also get just the max rating value:
            Optional<Integer> maxRatingValue = employees.stream()
                    .map(Employee::getRating)
                    .max(Integer::compare);
            maxRatingValue.ifPresent(rating -> System.out.println("Max Rating Value: " + rating));
            System.out.println("------------------------------------");


            // --- 5. Find the Min Rating ---
            Optional<Employee> minRatedEmployee = employees.stream()
                    .min(Comparator.comparingInt(Employee::getRating));

            minRatedEmployee.ifPresent(emp -> System.out.println("Employee with Min Rating: " + emp));
            // You can also get just the min rating value:
            Optional<Integer> minRatingValue = employees.stream()
                    .map(Employee::getRating)
                    .min(Integer::compare);
            minRatingValue.ifPresent(rating -> System.out.println("Min Rating Value: " + rating));
            System.out.println("------------------------------------");

            List<Employee> salaryList = employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary))
                    .collect(Collectors.toList());
            System.out.println("Sorted by Salary:");
            salaryList.forEach(System.out::println);

            System.out.println("------------------------------------");

            // Filter employees with salary greater than 20000
            List<String> highSalaryEmployees = employees.stream()
                    .filter(emp -> emp.getSalary() > 20000)
                    .map(Employee::getName)
                    .collect(Collectors.toList());
            System.out.println("Employees with Salary > 20000:");
            highSalaryEmployees.forEach(System.out::println);

            // Or to print as a single list:
             System.out.println(highSalaryEmployees);

        }
}
