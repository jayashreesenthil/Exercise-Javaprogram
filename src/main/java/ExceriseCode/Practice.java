package ExceriseCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Practice {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("abc", 1);
        map.put("def", 2);
        map.put("ghi", 3);
        map.put("abc", 4);
        map.put("mno", null);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}
