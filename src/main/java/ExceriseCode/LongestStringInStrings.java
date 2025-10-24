package ExceriseCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class LongestStringInStrings {
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "cherry", "watermelon", "kiwi"};
        String longestString = "";
        for (String str : strings) {
            if (str.length() > longestString.length()) {
                longestString = str;
            }
        }
        System.out.println("The longest string is: " + longestString);


        String[] words = {"cat", "elephant", "dog", "antelope", "mouse"};
        String longestWord = Arrays.stream(words)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println("The longest word is: " + longestWord);
    }
}
