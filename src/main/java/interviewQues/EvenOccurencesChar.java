package interviewQues;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;;

public class EvenOccurencesChar {
    public static void main(String[] args) {
        String s= "java programming";
        if(s == null || s.isEmpty()) {
            System.out.println("Input string is null or empty");
            return;
        }

        Map<Character, Long> map = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("occurrences:" + map);

        boolean result = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue) // Get the count of the most frequent character
                .map(count -> count % 2 == 0) // Check if the count is even
                .orElse(false);
        System.out.println(result);
    }
}
