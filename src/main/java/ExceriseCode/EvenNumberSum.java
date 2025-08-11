package ExceriseCode;

import java.util.Arrays;
import java.util.List;

public class EvenNumberSum {
    public static void main(String[] args) {

        List<Integer> number = Arrays.asList(1,0,2,5,10,11,23,4,12,25);
        // Find the even numbers and calculate the sum of all even elements
        int sumOfEvenNumbersAlt = number.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue) // Convert Stream<Integer> back to IntStream for sum()
                .sum();

        System.out.println("Sum of Even Numbers: " + sumOfEvenNumbersAlt);
    }
}
