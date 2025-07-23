package ExceriseCode;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
        // Create a HashMap with some values
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("abc", 1);
        map.put("def", 2);
        map.put("ghi", 3);
        map.put("abc", 4);
        map.put("mno", null);

        // Print out the key-value pairs in the HashMap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Create a List of Integers
        List<Integer> intArray = Arrays.asList(1, 1, 2, 3, 2, 4, 5, 5);

        // Use a stream to filter out the odd numbers and print them to the console
        intArray.stream()
                .filter(x -> x % 2 != 0)
                .forEach(System.out::println);
    }
}
