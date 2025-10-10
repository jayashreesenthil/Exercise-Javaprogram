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
        map.put(null, null);
        //map.put(null, 5);

        // Print out the key-value pairs in the HashMap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
