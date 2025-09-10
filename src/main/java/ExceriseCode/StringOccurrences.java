package ExceriseCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringOccurrences {

    public static void main(String[] args) {
        String[] s = {"a", "b", "c", "a", "a", "b"};

        // Use Java 8 Streams to count occurrences
        Map<String, Long> occurrences = Arrays.stream(s) // Convert array to a Stream<String>
                .collect(Collectors.groupingBy( // Group elements
                        str -> str, // Classifier function: group by the string itself
                        Collectors.counting() // Downstream collector: count elements in each group
                ));

        // Print the results
        System.out.println("Occurrences of each string:");
        occurrences.forEach((key, value) ->
                System.out.println("'" + key + "': " + value));


        // Use a HashMap to store string occurrences (key: string, value: count)
        Map<String, Integer> occurrence = new HashMap<>();

        // Iterate through the array using a traditional for-each loop
        for (String str : s) {
            // Check if the string is already in the map
            if (occurrence.containsKey(str)) {
                // If it exists, increment its count
                occurrence.put(str, occurrence.get(str) + 1);
            } else {
                // If it's a new string, add it to the map with a count of 1
                occurrence.put(str, 1);
            }
        }

        // Print the results using a traditional for-each loop over the map's entry set
        System.out.println("Occurrences of each string:");
        for (Map.Entry<String, Integer> entry : occurrence.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
    }
}
