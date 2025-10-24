package interviewQues;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringsByLength {
    public static void main(String[] args) {
        // 1. Define the input list of strings
        List<String> words = Arrays.asList(
                "apple", "banana", "cat", "dog", "elephant", "frog", "ant", "kiwi"
        );

        System.out.println("Input List: " + words);
        System.out.println("\n--- Grouping Strings By Length ---");

        // 2. Use the Stream API to perform the grouping
        Map<Integer, List<String>> groupedMap = words.stream()
                .collect(Collectors.groupingBy(
                        // The classifier function: uses String::length to determine the map key
                        String::length));

        // 3. Print the resulting map
        groupedMap.forEach((length, stringList) ->
                System.out.println("Length " + length + ": " + stringList)
        );
    }
}
