package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Map example
        List<String> stringList = Arrays.asList("a", "b", "c");
        List<String> mapString = stringList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(mapString);

         //Creating a List of Lists
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Apple", "Mango"),
                Arrays.asList("Orange", "Grape"),
                Arrays.asList("Guava", "Berries")
        );
        System.out.println(listOfLists);
         //Using Stream flatMap(Function mapper)
        List<String> flatMap = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flatMap);

//        List<Integer> employeeSalary = Arrays.asList(1000,2000,300,5000,5000,50000);
//            Optional<Integer> secondSalary = employeeSalary.stream()
//                    .distinct() // Remove duplicates
//                    .sorted(Comparator.reverseOrder()) // Sort in descending order
//                    .skip(1) // Skip the highest salary
//                    .findFirst(); // Get the second highest
//        System.out.println("Second Highest Salary:" +secondSalary);

//        List<Integer> number = Arrays.asList(1,0,5,10000,25,60,50,1000,2000,300,5000,5000,50000);
//        List<Integer> natureOrder = number.stream()
//              //  .sorted(Comparator.naturalOrder())
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList());
//        System.out.println(natureOrder);

        String str = "HelloWorld";
        Map<Character, Long> charOccurrence= str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charOccurrence);
        charOccurrence.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        //charOccurrence.forEach((character, count) -> System.out.println(character + ": " + count));
        String str1="Java is very fun and Java is more interesting";
        Map<String,Long> wordCounts=Arrays.stream(str1.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(wordCounts);

        //Duplicates in String str1
        wordCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times"));


        //Find first non-repeating character in Str2 //OUTPUT:w
        String str2="swiss";
        Map<Character, Long> charCount = str2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
           // System.out.println(charCount);
//        charCount.forEach((character,count) -> {
//            if (count == 1) {
//                System.out.println("First non-repeating character in '" + str2 + "': " + character);
//            }
//        });
        charCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .ifPresent(entry -> System.out.println("First non-repeating character in '" + str2 + "': " + entry.getKey()));
//       charCount.entrySet().stream()
//                .filter(entry -> entry.getValue() == 1)
//                .map(Map.Entry::getKey)
//                .findFirst()
//                .orElse(null);
//        System.out.println("First non-repeating character in '" + str2 + "': " + charCount);

        // Find unique number in intList
        List<Integer> intList = Arrays.asList(1, 1, 2, 3, 2, 4, 5, 5);
        List<Integer> uniquenumber = intList.stream()
                .distinct()
                .collect(Collectors.toList());

        uniquenumber.forEach(System.out::println); // Print each unique element
        System.out.println("Unique elements list: " + uniquenumber);

        Map<Integer, Long> intCount = intList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        intCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .ifPresent(entry -> System.out.println("First non-repeating integer in list: " + entry.getKey()));

        //int[] intArray = {1, 2, 3, 2, 4, 5, 5, 6};
        List<Integer> intArray = Arrays.asList(1, 1, 2, 3, 2, 4, 5, 5);
        List<Integer> duplicates = intArray.stream()
                //.boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Duplicate Integer: " +duplicates); // Output: [1, 2, 5]
    Map<Integer, Long> intMap = intArray.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            intMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toList())
                    .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


        //Given a sorted integer array nums, return an array of the squares of each number, also sorted in non-decreasing order.
        //Example:
        // Input: [-4, -1, 0, 3, 10]
        // Output: [0, 1, 9, 16, 100]

        int[] sortArray={-4, -1, 0, 3, 10};
        int[] arraySorted = Arrays.stream(sortArray)
                .map(n -> n*n)
                .sorted()
                .boxed()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("Sorted array: " + Arrays.toString(arraySorted));

        List<Integer> arrSort = Arrays.stream(sortArray)      // Creates an IntStream from the int[]
                .map(n -> n*n)                            // Squares each number (still an IntStream)
                .sorted()                                    // Sorts the squared numbers (still an IntStream)
                .boxed()                                     // Converts each int to an Integer (creates a Stream<Integer>)
                .collect(Collectors.toList());               // Collects the elements into a List<Integer>
        System.out.println("Sorted array: " + arrSort);

    }
}