package ExceriseCode;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueCharactersInStrings {

    /**
     * Finds and prints the unique characters for each string in an array.
     *
     * @param stringArray The array of strings to process.
     */
    public static void findUniqueCharacters(String[] stringArray) {
        for (String str : stringArray) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char ch : str.toCharArray()) {
                uniqueChars.add(ch); // HashSet automatically handles uniqueness
            }
            System.out.println("Unique characters in \"" + str + "\": " + uniqueChars);
        }
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "programming", "java", "unique"};
        findUniqueCharacters(words);

        //Java 8
        String input = "programming";
        String unique = input.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("Unique characters in \"" + input + "\": " + unique);

        //Single String to Character Array and find unique characters
        char[] charArray = input.toCharArray();
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : charArray) {
            uniqueChars.add(ch); // HashSet automatically handles uniqueness
        }
        System.out.println("Unique characters in \"" + input + "\": " + uniqueChars);
        List<Character> reversedList = new ArrayList<>(uniqueChars);
        Collections.reverse(reversedList);
        System.out.println("Reversed unique characters: " + reversedList);
    }

//    public static String findUniqueCharacters(String str) {
//        Set<Character> uniqueChars = new HashSet<>();
//        StringBuilder result = new StringBuilder();
//
//        for (char ch : str.toCharArray()) {
//            if (uniqueChars.add(ch)) { // add() returns true if the element was added (i.e., it's unique)
//                result.append(ch);
//            }
//        }
//        return result.toString();
//    }
//
//    public static void main(String[] args) {
//        String input = "programming";
//        String unique = findUniqueCharacters(input);
//        System.out.println("Unique characters in \"" + input + "\": " + unique); // Output: Unique characters in "programming": progamni
//    }



}
