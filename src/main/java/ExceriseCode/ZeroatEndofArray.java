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
    }
}
