package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String str = "HelloWorld";
        Map<Character, Long> charOccurrence= str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charOccurrence);
        charOccurrence.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        String[] s = {"a", "b", "c", "c", "a", "a", "e"};
        Map<String, Long> occurrences = Arrays.stream(s)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        occurrences.forEach((key, value) -> System.out.println(key + " : " + value));

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

        Set<Integer> uniqueSet = intList.stream().collect(Collectors.toSet());

        System.out.println("Unique elements set: " + uniqueSet);


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
                    .forEach(entry -> System.out.println("Occurence : " + entry.getKey() + " : " + entry.getValue()));

    }
}