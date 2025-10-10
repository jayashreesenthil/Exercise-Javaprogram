package ExceriseCode;

import java.util.HashSet;
import java.util.Set;

public class hashset {
    public static void main(String[] args) {
//        HashSet<String> set = new HashSet<>();
//        set.add("Apple");
//        set.add("Banana");
//        set.add("Orange");
//        set.add("Apple"); // Duplicate, will not be added
//
//        System.out.println("HashSet contains:");
//        for (String fruit : set) {
//            System.out.println(fruit);
//        }

        Set<String> mySet = new HashSet<>();

        System.out.println("Adding null for the first time: " + mySet.add(null)); // true
        System.out.println("Adding null for the second time: " + mySet.add(null)); // false

        mySet.add("Hello");
        mySet.add("World");
        mySet.add("Hello"); // Duplicate, won't be added
        System.out.println("Set contents: " + mySet); // [null]
        System.out.println("Set size: " + mySet.size()); // 1
    }
}
