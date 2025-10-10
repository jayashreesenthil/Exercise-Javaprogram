package ExceriseCode;

import java.util.Arrays;
import java.util.List;

public class findOddNum {
    public static void main(String[] args) {
        // Create a List of Integers
        List<Integer> intArray = Arrays.asList(1, 1, 2, 3, 2, 4, 5, 5);

        // Use a stream to filter out the odd numbers and print them to the console
        intArray.stream()
                .filter(x -> x % 2 != 0)
              //  .distinct() use if you want to print only unique odd numbers
                .forEach(System.out::println);

    }
}
