package ExceriseCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using a parallel stream to filter and double numbers
        List<Integer> processedNumbers = numbers.parallelStream()
                .filter(n -> n % 2 == 0) // Filter even numbers
               // .map(n -> n * 2)       // Double the even numbers
                .map(n -> n*n)
                .collect(Collectors.toList()); // Collect results

        System.out.println("Processed Numbers (Parallel): " + processedNumbers);
    }
}
