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


        Map<Integer, Long> counts = intList.stream()
                .collect(Collectors.groupingBy(
                        num -> num,        // Group by the number itself
                        Collectors.counting() // Count occurrences of each number
                ));

        // Step 2: Filter the map entries to find numbers with a count of 1
        // Then, extract these numbers and print them
        System.out.println("Numbers that appear exactly once:");
        counts.entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Filter for entries where count is 1
                .map(Map.Entry::getKey)                 // Get the number (key) from the filtered entry
                .forEach(System.out::println);


        int[] input = {2, 3, 1, 0, 4};

        // Use a single stream to partition numbers into even and odd lists.
        // The key of the map will be a boolean: true for even, false for odd.
        Map<Boolean, List<Integer>> oddEvenPartition = Arrays.stream(input)
                .boxed() // Convert from IntStream to Stream<Integer>
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        // Retrieve the lists from the map.
        List<Integer> evenNumbers = oddEvenPartition.get(true);
        List<Integer> oddNumbers = oddEvenPartition.get(false);

        System.out.println("Even Numbers: " + evenNumbers);
        int l= evenNumbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Even Numbers: " + l);
        System.out.println("Odd Numbers: " + oddNumbers);
    }

}
