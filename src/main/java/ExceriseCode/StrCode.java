package ExceriseCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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

      // input s= "jjava" - ouput - find the occurence of each character
        String s="jjava";
        Map<Character, Long> map = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet()
                .forEach((entry) -> System.out.println(entry.getKey() + " " + entry.getValue()));

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


        //Count the characters in a string and display the count next to each character

        String input = "ABBCCCD";
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(input.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count).append(input.charAt(input.length() - 1));
        System.out.println(result);

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

    }
}
