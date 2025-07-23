package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StringPalindrome {

    public static void main(String[] args) {
        // Example
//        String str = "first";
//        System.out.println(str + " is palindrome: " + (str.equals(new StringBuilder(str).reverse().toString())));

        // Ask user for input
//        String a ="";
        String b ="";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String a= s.nextLine();
//        for (int i = 0; i < a.length(); i++) {
//            //System.out.println("Character at index " + i + ": " + a.charAt(i));
//            a.charAt(i)
//        }

        // Reverse the string
        for(int i=a.length()-1; i>=0; i--){
            b=b+a.charAt(i);
        }
        System.out.println("String b is : "+b);
        // Check if the input string is a palindrome
        if(a.equals(b))
            System.out.println("String is palindrome "+a);
        else
            System.out.println("String is not palindrome "+a);
    }
}
