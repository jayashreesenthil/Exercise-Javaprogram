package ExceriseCode;

import java.util.Scanner;

public class CharString {
    public static void main(String[] args) {

        //Character Array to String
        char[] charArrays = {'h', 'e', 'l', 'l', 'o'};
        String string = new String(charArrays);
        String str = String.valueOf(charArrays);
        System.out.println(string);
        //String to Character Array
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();
        char[] charArray = input.toCharArray();
        System.out.println("Character array: ");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        
    }
}
