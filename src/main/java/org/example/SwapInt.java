package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SwapInt {
    public static void main(String[] args) {
//        int num1 = 5;
//        int num2 = 10;

        //user input
        Scanner numbers = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = numbers.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = numbers.nextInt();

        System.out.println("Before swap: n1 = " +num1+ " n2 = " +num2);
        //System.out.println("Before swap: num1 = " + num1 + " num2 = " + num2);
       // with temporary variable
//        int temp = num1;
//        num1 = num2;
//        num2 = temp;

        //without temporary variable
//        num1 = num1 + num2; // num1 now becomes 15
//        num2 = num1 - num2; // num2 becomes 5
//        num1 = num1 - num2; // num1 becomes 10

//        // or using Java 8's lambda expression
//        num1 = num1 ^ num2;
//        num2 = num1 ^ num2;
//        num1 = num1 ^ num2;

        // or using Java 8's method reference
num1 = (num1 + num2) - (num2 = num1);
       System.out.println("After swap: n1 = " + num1 + " n2 = " + num2);


       //code with user input to find the duplicates
        //int[] intArray = {1, 2, 3, 2, 4, 5, 5, 6};
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no of integer: ");
        int num = scan.nextInt();

        System.out.println("Enter the integers: ");
        int[] intArray = new int[num];

        for (int i = 0; i < num; i++) {
            intArray[i] = scan.nextInt();
        }

        List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        System.out.println(intList);

        Map<Integer,Long> map = intList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("Duplicates: " + entry.getKey() + " : " + entry.getValue()));


//        List<Integer> duplicates = intArray.stream()
//                //.boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .filter(entry -> entry.getValue() > 1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());

        //print 1 to 100 without number
        for(int i='A'-'@'; i<'e'; i++){
            System.out.print(i);
        }
    }
}
