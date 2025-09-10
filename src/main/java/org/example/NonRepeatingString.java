package org.example;

import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingString {

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        System.out.println("Enter the string: ");

        String s = str.nextLine();
        System.out.println("Entered string is : "+s);
        Map<Character, Long> charCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Character count: " + charCount);

        charCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .ifPresent(entry -> System.out.println("First non-repeating character: " + entry.getKey()));


    }

}
