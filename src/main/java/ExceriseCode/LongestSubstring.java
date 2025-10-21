package ExceriseCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s="abcabcbb";
        int maxLen = 0;
        int left = 0;
        //Sliding Window using Set
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println(maxLen);;
    }
        //"abcabcbb" // Output: 3
        //"bbbb" // Output: 1

    //By using Map
//    Map<Character, Integer> lastIndex = new HashMap<>();
//    int left = 0, maxLen = 0;
//        for (int right = 0; right < s.length(); right++) {
//        char c = s.charAt(right);
//        if (lastIndex.containsKey(c)) {
//            // move left to one position after the previous index of c
//            left = Math.max(left, lastIndex.get(c) + 1);
//        }
//        lastIndex.put(c, right);
//        maxLen = Math.max(maxLen, right - left + 1);
//    }
//        return maxLen;
}