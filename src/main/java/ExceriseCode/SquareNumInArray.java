package ExceriseCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareNumInArray {
    public static void main(String[] args) {
        //Given a sorted integer array nums, return an array of the squares of each number, also sorted in non-decreasing order.
        //Example:
        // Input: [-4, -1, 0, 3, 10]
        // Output: [0, 1, 9, 16, 100]

        int[] sortArray={-4, -1, 0, 3, 10};
        int[] arraySorted = Arrays.stream(sortArray)
                .map(n -> n*n)
                .sorted()
                .boxed()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("Sorted array: " + Arrays.toString(arraySorted));

        List<Integer> arrSort = Arrays.stream(sortArray)      // Creates an IntStream from the int[]
                .map(n -> n*n)                            // Squares each number (still an IntStream)
                .sorted()                                    // Sorts the squared numbers (still an IntStream)
                .boxed()                                     // Converts each int to an Integer (creates a Stream<Integer>)
                .collect(Collectors.toList());               // Collects the elements into a List<Integer>
        System.out.println("Sorted array: " + arrSort);


    }
}
