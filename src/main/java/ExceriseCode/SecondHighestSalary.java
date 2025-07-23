package ExceriseCode;

// No loops, no manual checks — solve this using Stream only

//Q1 – Find the Second Highest Number from an Unsorted List
//Q2 – Find the 2nd Value Present in the List (by index)

//Q1:
//Use , .sorted(), .limit()
//Reverse the sort, pick the second value

// Q2:
//Just use .skip(1).findFirst()

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondHighestSalary {
    public static void main(String[] args) {

        List<Integer> number = Arrays.asList(1,0,5,10000,25,60,50,1000,2000,300,5000,5000,50000);
        int secondSalary = number.stream()
                .distinct()
                    .sorted(Comparator.reverseOrder()) // Sort in descending order
                    .skip(1) // Skip the highest salary
                    .findFirst().get(); // Get the second highest
        System.out.println("Second Highest Salary:" +secondSalary);

        // Find the smallest element
        Optional<Integer> min = number.stream()
                .min(Integer::compareTo); // Or Comparator.naturalOrder()
       // System.out.println("Smallest element: " + min.get());

        // Print the results, handling the Optional type
        if (min.isPresent()) {
            System.out.println("Smallest element: " + min.get());
        } else {
            System.out.println("The list is empty.");
        }

        // Find the largest element
        Optional<Integer> max = number.stream()
                .max(Integer::compareTo); // Or Comparator.naturalOrder()
        //System.out.println("Largest element: " + max.get());

        if (max.isPresent()) {
            System.out.println("Largest element: " + max.get());
        } else {
            System.out.println("The list is empty.");
        }

        // Find the even numbers and calculate the sum of all even elements
        int sumOfEvenNumbersAlt = number.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue) // Convert Stream<Integer> back to IntStream for sum()
                .sum();

        System.out.println("Sum of Even Numbers: " + sumOfEvenNumbersAlt);


    }

}
