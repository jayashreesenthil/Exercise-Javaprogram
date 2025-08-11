package ExceriseCode;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


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
            System.out.println(c + " ");
        }

        String s="Hello World";
        String uniqueChars = s.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

//        List<String> uniqueCharsList = s.chars()
//                .distinct()
//                .mapToObj(c -> String.valueOf((char) c))
//                .collect(Collectors.toList());
//        System.out.println(uniqueCharsList);
        System.out.println("Unique characters: " + uniqueChars);

    }
}
