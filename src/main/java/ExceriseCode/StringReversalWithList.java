package ExceriseCode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringReversalWithList {

    public static void main(String[] args) {
        String originalString = "hello world";
        System.out.println("Original String: " + originalString);

        // 1. Get a list of characters from the string
        List<Character> charList = originalString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        // 2. Reverse the list of characters
        Collections.reverse(charList);

        // 3. Join the characters back into a string
        String reversedString = charList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Reversed String (with List): " + reversedString);
    }
}
