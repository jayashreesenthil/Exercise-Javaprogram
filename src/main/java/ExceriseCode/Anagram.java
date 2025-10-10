package ExceriseCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("Input: " + Arrays.toString(input));

        // 1. Stream the input array.
        // 2. Group the strings by a canonical key (the sorted version of the string).
        // 3. Collect the resulting groups into a Map<String, List<String>>.
        Collection<List<String>> groupedAnagrams = Arrays.stream(input)
                .collect(Collectors.groupingBy(
                        // Key Mapper: Function to generate the canonical key (sorted string)
                        str -> {
                            char[] chars = str.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        },
                        // Downstream Collector: Collects all original strings into a List
                        Collectors.toList()))
                .values(); // Extract only the lists of anagrams (the map values)

        List<List<String>> streamResult = new ArrayList<>(groupedAnagrams);

        System.out.println("\n--- 1. Stream API Result ---");
        System.out.println(streamResult);

    }
}
