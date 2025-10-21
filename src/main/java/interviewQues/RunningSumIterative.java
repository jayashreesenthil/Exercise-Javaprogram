package interviewQues;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class RunningSumIterative {
    public static void main(String[] args) {
        //1. Iterative Approach
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(nums));

        // Start from the second element (index 1)
        for (int i = 1; i < nums.length; i++) {
            // Update the current element to be the sum of itself and the previous running sum
            nums[i] = nums[i] + nums[i - 1];
        }

        System.out.println("Running Sum (Iterative): " + Arrays.toString(nums));  // Output: [1, 3, 6, 10, 15]

        //2. Using Arrays.parallelPrefix() (Java 8+)
        int[] num = {10, 5, 2, 1};
        System.out.println("Original Array: " + Arrays.toString(num));

        // Define the operation: simple addition
        IntBinaryOperator accumulator = (left, right) -> left + right;

        // Apply the prefix sum operation directly to the array
        Arrays.parallelPrefix(num, accumulator);

        System.out.println("Running Sum (ParallelPrefix): " + Arrays.toString(num));
        // Output: [10, 15, 17, 18]
    }
}
