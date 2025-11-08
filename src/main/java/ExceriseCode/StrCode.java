package ExceriseCode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StrCode {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3= "Java";
       System.out.println(str1.compareTo(str2));
       System.out.println(str2.compareTo(str3));
       System.out.println(str3.compareTo(str1));


        //Remove consecutive duplicate characters from a string
        //input: "ABBCCCD" - output: "ACD"

//        String input = "ABBCCCD";
//        String result = "";
//        if (input != null && !input.isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(input.charAt(0));
//            for (int i = 1; i < input.length(); i++) {
//                char currentChar = input.charAt(i);
//                char lastAppendedChar = sb.charAt(sb.length() - 1);
//                if (currentChar != lastAppendedChar) {
//                    sb.append(currentChar);
//                }
//            }
//            result = sb.toString();
//        }
//        System.out.println(result);


//        String input = "ABBCCCD";
//        StringBuilder result = new StringBuilder();
//        if (input != null && !input.isEmpty()) {
//            result.append(input.charAt(0));
//            for (int i = 1; i < input.length(); i++) {
//                if (input.charAt(i) != input.charAt(i - 1)) {
//                    result.append(input.charAt(i));
//                }
//            }
//        }
//        System.out.println(result); // Output: ACD



        //Extract only the letters from a given alphanumeric string
        String sr = "1A2B3C1D";
        StringBuilder output = new StringBuilder();
        for (char c : sr.toCharArray()) {
            if (Character.isLetter(c)) {
                output.append(c);
            }
        }
        System.out.println(output);

        String it = "2a2b2c";
        String output1 = it.chars()
                .filter(Character::isLetter)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(output1);

        String test = "Hi hello";
        char c = 'h';
        long count1 = test.chars()
                .filter(ch -> ch == c)
                .count();
        System.out.println(count1);

//find the vowel and non-vowel counts in a string

        String s1="capgemini";
        Map<Character, Long> vowelCounts = s1.chars() // Returns an IntStream of characters (as their ASCII values)
                .mapToObj(ch -> (char) ch) // Convert IntStream to Stream<Character>
                .filter(ch-> "aeiouAEIOU".indexOf(ch) != -1) // Filter for vowels only
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        System.out.println("vowel counts in \"" + s1 + "\": " +vowelCounts);

        Map<Character, Long> nonVowelCounts = s1.chars() // Returns an IntStream of characters (as their ASCII values)
                .mapToObj(ca -> (char) ca) // Convert IntStream to Stream<Character>
                .filter(ca -> "aeiouAEIOU".indexOf(ca) == -1) // Filter for non-vowels
                .collect(Collectors.groupingBy(ca -> ca, Collectors.counting()));

        System.out.println("Non-vowel counts in \"" + s1 + "\": " + nonVowelCounts);

        String[] ss= {"apple", "banana", "air", "orange", "banana", "an", "kiwi"};
        List<String> nameList = Arrays.stream(ss).filter(word -> word.startsWith("a")).toList();
        System.out.println(nameList);

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = intList.stream()
                .mapToInt(Integer::intValue) // Convert to IntStream
                .sum(); // Sum the even numbers
        System.out.println("Sum of integers in the list: " + sum);

    }
}
