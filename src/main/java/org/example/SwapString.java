package org.example;

public class SwapString {
    public static void main(String[] args) {
        String a = "first";
        String b = "second";
        System.out.println("Before swap: a = " + a + " b = " + b);
        // Swap the strings
        a = a + b;
        b = a.substring(0, a.length() - b.length());
        a = a.substring(b.length());
        System.out.println("After swap: a = " + a + " b = " + b);

        //with temporary variable
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("Before swap:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        // Swap the strings
        String temp = str1;
        str1 = str2;
        str2 = temp;
        System.out.println("After swap:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
    }
}
