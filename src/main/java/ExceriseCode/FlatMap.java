package ExceriseCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        //Creating a List of Lists
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Apple", "Mango"),
                Arrays.asList("Orange", "Grape"),
                Arrays.asList("Guava", "Berries")
        );
        System.out.println(listOfLists);
        //Using Stream flatMap(Function mapper)
        List<String> flatMap = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flatMap);

        //Map example
        List<String> stringList = Arrays.asList("a", "b", "c");
        List<String> mapString = stringList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(mapString);
    }
}
