package ExceriseCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class NthlargeElement {

        public static void main(String[] args) {
            // Find the 3rd largest element from an integer array using Java 8 Streams
            int arr[] = {12, 4, 3, 1, 9, 657};
            int n = 3; // Find the N-th largest, in this case the 3rd highest element

            System.out.println("Original Array: " + Arrays.toString(arr));

            // Stream to find the N-th largest element
            Optional<Integer> nthLargest = Arrays.stream(arr)          // 1. Create an IntStream from the array
                    .boxed()                                           // 2. Convert IntStream to Stream<Integer>
                    .sorted(Comparator.reverseOrder())                 // 3. Sort in descending order
                    .skip(n - 1)                                    // 4. Skip the first (N - 1) elements
                    .findFirst();                                      // 5. Find the first element remaining

            System.out.print("The " + n + "rd largest element is: ");

            // Check if an element was found and print it
            nthLargest.ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Not found (array is too small)")
            );
        }
}
