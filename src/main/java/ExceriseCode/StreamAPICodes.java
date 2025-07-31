package ExceriseCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPICodes {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("add", "data", "domains", "insect", "ant");

        // Sort the list using a custom comparator
        List<String> sortedList = list.stream()
                // Primary sort: by length in descending order
                .sorted(Comparator.comparingInt(String::length).reversed()
                        // Secondary sort: for ties in length, sort alphabetically (natural order)
                        .thenComparing(Function.identity())) // Function.identity() is equivalent to s -> s
                .collect(Collectors.toList());

        System.out.println("Original List: " + list);
        System.out.println("Sorted List: " + sortedList);



//        List<String> nameLists= Arrays.asList("insect", "and","ant","domain", "flow", "is", "a");
//        List<String> sortname= nameLists.stream()
//                .sorted(Comparator.comparingInt(String::length).reversed())
//                //.thenComparing(Function.identity()))
//                .collect(Collectors.toList());
//        System.out.println(sortname);

    }
}
