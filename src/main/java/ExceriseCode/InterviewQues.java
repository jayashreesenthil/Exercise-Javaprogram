package ExceriseCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InterviewQues {

    //HSBC interview question

    /**
     * Finds two elements in the given array that add up to the given target,
     * and returns their indices.
     *
     * @param nums the array of numbers
     * @param target the target sum
     * @return an array of two indices
     * @throws RuntimeException if no solution is found
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {
                        map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("No solution found");
    }
    public static void main(String[] args) {

        InterviewQues solution = new InterviewQues();
        int[] nums = {2, 8, 11, 7};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Output: [0, 3]

        System.out.println(result); // Output: [I@15db9742 - Without Arrays.toString, printing the array directly would display its memory address, not its contents.


    }
}