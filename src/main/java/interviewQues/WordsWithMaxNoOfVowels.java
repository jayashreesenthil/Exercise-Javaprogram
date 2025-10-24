package interviewQues;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WordsWithMaxNoOfVowels {
    public static void main(String[] args) {

        // A list of other words to compare against
        List<String> words = Arrays.asList(
                "education",
                "strength",
                "programming",
                "idea",
                "AEIOU"
        );

        // Define the set of vowels (case-insensitive)
        final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

        System.out.println("Input Words List: " + words);

        // 1. Group the words by their vowel count
        Map<Long, List<String>> groupedByVowelCount = words.stream()
                .collect(Collectors.groupingBy(
                        // The classifier function counts vowels
                        word -> word.toLowerCase().chars()
                                .mapToObj(c -> (char) c)
                                .filter(VOWELS::contains)
                                .count()));

        // 2. Find the maximum vowel count (the largest key in the map)
        long maxVowelCount = groupedByVowelCount.keySet().stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(0L);


        // 3. Retrieve the list of words corresponding to the maximum count
        List<String> wordsWithMaxVowels = groupedByVowelCount.getOrDefault(maxVowelCount, List.of());

        // --- Output ---
        System.out.println("Maximum Vowel Count Found: " + maxVowelCount);
        System.out.println("Words with Max Vowels: " + wordsWithMaxVowels);

    }
}
