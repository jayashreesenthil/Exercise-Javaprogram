package interviewQues;

public class BinarySearch {
    //Find the index of an element in a sorted array using binary search algorithm

    public static int findIndex(int[] sortedArray, int target) {
        // Initialize the pointers for the search space
        int low = 0;
        int high = sortedArray.length - 1;

        // Continue searching as long as the search space is valid
        while (low <= high) {
            // Calculate the middle index.
            // Using this formula prevents integer overflow compared to (low + high) / 2
            int mid = low + (high - low) / 2;

            // Case 1: Target found!
            if (sortedArray[mid] == target) {
                return mid;
            }
            // Case 2: Target is in the right half
            else if (sortedArray[mid] < target) {
                // Ignore the left half and the middle element
                low = mid + 1;
            }
            // Case 3: Target is in the left half
            else { // sortedArray[mid] > target
                // Ignore the right half and the middle element
                high = mid - 1;
            }
        }

        // If the loop finishes, the element was not found in the array.
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {5, 12, 18, 25, 30, 42, 55, 61, 78, 89};

        System.out.println("Sorted Array: {5, 12, 18, 25, 30, 42, 55, 61, 78, 89}\n");

        // --- Test Case 1: Element in the middle ---
        int target1 = 30;
        int index1 = findIndex(data, target1);
        System.out.println("Searching for " + target1);
        System.out.println("Result: Index " + index1 + " (Expected: 4)");
        System.out.println("--------------------");

        // --- Test Case 2: Element at the start ---
        int target2 = 5;
        int index2 = findIndex(data, target2);
        System.out.println("Searching for " + target2);
        System.out.println("Result: Index " + index2 + " (Expected: 0)");
        System.out.println("--------------------");

        // --- Test Case 3: Element at the end ---
        int target3 = 89;
        int index3 = findIndex(data, target3);
        System.out.println("Searching for " + target3);
        System.out.println("Result: Index " + index3 + " (Expected: 9)");
        System.out.println("--------------------");

        // --- Test Case 4: Element not present ---
        int target4 = 50;
        int index4 = findIndex(data, target4);
        System.out.println("Searching for " + target4);
        System.out.println("Result: Index " + index4 + " (Expected: -1)");
        System.out.println("--------------------");
    }
}
