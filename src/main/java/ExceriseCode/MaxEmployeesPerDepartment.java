package ExceriseCode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Represents a Department
class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // It's crucial to override equals() and hashCode() if Department objects
    // are used as keys in a Map, especially when groupingBy.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id; // Equality based on ID
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

// Represents an Employee
class Employee {
    private int id;
    private String name;
    private Department department; // Reference to Department object
    private double salary;

    public Employee(int id, String name, Department department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department.getName() +
                ", salary=" + salary +
                '}';
    }
}

public class MaxEmployeesPerDepartment {

    public static void main(String[] args) {
        // Sample data
        Department hr = new Department(101, "HR");
        Department engineering = new Department(102, "Engineering");
        Department sales = new Department(103, "Sales");

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", hr, 60000.0),
                new Employee(2, "Bob", engineering, 75000.0),
                new Employee(3, "Charlie", hr, 65000.0),
                new Employee(4, "David", sales, 90000.0),
                new Employee(5, "Eve", engineering, 80000.0),
                new Employee(6, "Frank", hr, 70000.0),
                new Employee(7, "Grace", sales, 85000.0)
        );

        // Step 1: Group employees by department and count them
        Map<Department, Long> employeeCountByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, // Key: Department object
                        Collectors.counting()    // Value: Count of employees in that department
                ));

        System.out.println("Employee Count per Department:");
        employeeCountByDepartment.forEach((dept, count) ->
                System.out.println("Department: " + dept.getName() + ", Employee Count: " + count)
        );

        // Step 2: Find the entry (Department and its count) with the maximum count - HR, 3
        Optional<Map.Entry<Department, Long>> maxEntryOptional = employeeCountByDepartment.entrySet().stream()
                .max(Map.Entry.comparingByValue()); // Compare map entries by their value (the count)

        System.out.println("\n--- Department with Maximum Employees ---");
        maxEntryOptional.ifPresent(entry -> {
            System.out.println("Department with Max Employees: " + entry.getKey().getName());
            System.out.println("Maximum Employee Count: " + entry.getValue());
        });

        // If you want to get only the maximum count value
        Optional<Long> maxCountValue = employeeCountByDepartment.values().stream()
                .max(Long::compare);

        System.out.println("\n--- Only the Maximum Employee Count Value ---");
        maxCountValue.ifPresent(count ->
                System.out.println("The maximum number of employees in any department is: " + count)
        );
    }
}
