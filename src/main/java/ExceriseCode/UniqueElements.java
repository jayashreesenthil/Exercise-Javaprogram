package ExceriseCode;

import java.util.HashSet;
import java.util.Set;

public class UniqueElements {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 4, 1, 5, 3};
        findUniqueElements(numbers);
    }

    public static void findUniqueElements(int[] arr) {
        Set<Integer> uniqueSet = new HashSet<>();

        System.out.print("Unique elements in the array: ");
        for (int element : arr) {
            // Add the element to the set. If it's already present, add() returns false.
            if (uniqueSet.add(element)) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }
}