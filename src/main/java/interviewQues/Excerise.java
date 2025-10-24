package interviewQues;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Excerise {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        IntStream stream1 = (arr1 != null) ? Arrays.stream(arr1) : IntStream.empty();
        IntStream stream2 = (arr2 != null) ? Arrays.stream(arr2) : IntStream.empty();

        int[] a =  IntStream.concat(stream1, stream2)
                .sorted()
                .toArray();
        System.out.println("Merged and Sorted Array: " + Arrays.toString(a));
    }
}
