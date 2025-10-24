package ExceriseCode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordOccurences {
    public static void main(String[] args) {
        String s= "hello world Hello java worLD hello";
        Map<String, Long> wordCount = Arrays.stream(s.toLowerCase().split("\\W+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(wordCount);
    }
}
