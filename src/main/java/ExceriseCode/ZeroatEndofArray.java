package ExceriseCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ZeroatEndofArray {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 0, 3, 0, 1, 0, 5, 6, 7);

        // Separate non-zeros and zeros, then combine them
        List<Integer> result = Stream.concat(
                        numbers.stream().filter(n -> n != 0), // Stream of non-zeros
                        numbers.stream().filter(n -> n == 0)  // Stream of zeros
                )
                .toList();

        System.out.println("Original list: " + numbers);
        System.out.println("List with zeros moved to end: " + result);

//        // 'insertPos' tracks the index where the next non-zero element should be placed.
//        int insertPos = 0;
//
//        // --- PASS 1: Move all non-zero elements to the front ---
//        // This preserves the relative order of non-zero elements.
//        for (int num : nums) {
//            if (num != 0) {
//                nums[insertPos] = num;
//                insertPos++;
//            }
//        }
//
//        // At this point, 'insertPos' is the index of the first zero that needs to be inserted.
//
//        // --- PASS 2: Fill the rest of the array with zeros ---
//        while (insertPos < nums.length) {
//            nums[insertPos] = 0;
//            insertPos++;
        }

}
