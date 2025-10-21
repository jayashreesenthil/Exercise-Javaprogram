package ExceriseCode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondNonRepeatingChar {
    public static void main(String[] args) {
        String s= "hhelloworld";

        Optional<Character> characterCounts = s.chars()
                .mapToObj(c -> (char) c) // Convert IntStream of char codes to Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, // IMPORTANT: Guarantees order of first appearance
                        Collectors.counting()
                ))
                .entrySet().stream()
                // Filter: Keep only entries where the count is 1 (non-repeated)
                .filter(entry -> entry.getValue() == 1)
                // Skip: Skip the first non-repeated character
                .skip(1)
                // Find: Get the next character (which is the second non-repeated one)
                .findFirst()
                // Map: Extract just the character (the key) from the Map.Entry
                .map(Map.Entry::getKey);
        //.get();
        System.out.println("Character counts: " + characterCounts);

    }

}
