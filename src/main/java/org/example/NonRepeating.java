package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeating {

    /**
     * Find the first non-repeating integer in the list.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of integers in the list:");
        int n = scanner.nextInt();

        System.out.println("Enter the integers:");
        int[] intArray = new int[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = scanner.nextInt();
        }

        // Create a list of integers from the array
        List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());

        // Count the occurrences of each integer in the list
        Map<Integer, Long> intCount = intList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Find the first non-repeating integer
        intCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .ifPresent(entry -> System.out.println("First non-repeating integer in list: " + entry.getKey()));
    }

}
