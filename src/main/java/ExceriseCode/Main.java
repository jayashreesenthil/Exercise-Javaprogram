package ExceriseCode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


// Define the Employee class
class Employees {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employees(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a list of Employee objects with string literals for departments
        List<Employees> employees = Arrays.asList(
                new Employees(1, "Alice", "hr", 60000.0),
                new Employees(2, "Bob", "engineering", 75000.0),
                new Employees(3, "Charlie", "hr", 65000.0),
                new Employees(4, "David", "sales", 90000.0),
                new Employees(5, "Eve", "engineering", 80000.0),
                new Employees(6, "Frank", "hr", 70000.0),
                new Employees(7, "Grace", "sales", 85000.0)
        );

        // Find the unique departments using Java 8 streams
        Set<String> uniqueDepartments = employees.stream()
                .map(Employees::getDepartment)
                .collect(Collectors.toSet());

        // Print the result
        System.out.println("Unique Departments:" + uniqueDepartments);
       // uniqueDepartments.forEach(System.out::println);

        // 1. Group employees by department and count them
        Map<String, Long> departmentCounts = employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment, Collectors.counting()));

        // 2. Find the maximum count among all departments
        long maxCount = departmentCounts.values().stream()
                .mapToLong(count -> count) // Convert to LongStream for max()
                .max()
                .orElse(0); // Default to 0 if the list is empty
        System.out.println("Maximum count: " + maxCount);

        // 3. Find the departments that have the highest count
        List<String> highestCountDepartments = departmentCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Departments with highest count: " + highestCountDepartments);

        // 4. Filter the original employee list to get names from those departments
        List<String> employeesInHighestCountDepartment = employees.stream()
                .filter(emp -> highestCountDepartments.contains(emp.getDepartment()))
                .map(Employees::getName)
                .collect(Collectors.toList());

       // System.out.println("The department(s) with the highest employee count is/are: " + highestCountDepartments);
        System.out.println("The employee names in this/these department(s) are: " + employeesInHighestCountDepartment);
    }
}
