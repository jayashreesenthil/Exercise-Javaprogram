package interviewQues;

public class MergeSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        if (arr1 == null) {
            return arr2 != null ? arr2 : new int[0];
        }
        if (arr2 == null) {
            return arr1;
        }

        int n = arr1.length;
        int m = arr2.length;

        int[] mergedArray = new int[n + m];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for mergedArray (current insertion index)
        // 3. Merging Process
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                // Element from arr1 is smaller or equal, so we take it.
                mergedArray[k] = arr1[i];
                i++; // Move arr1 pointer
            } else {
                // Element from arr2 is smaller, so we take it.
                mergedArray[k] = arr2[j];
                j++; // Move arr2 pointer
            }
            k++; // Always move the mergedArray pointer forward
        }

        // 4. Cleanup/Post-merge: Append any remaining elements.
        // If elements are left in arr1 (arr2 was exhausted first)
        while (i < n) {
            mergedArray[k] = arr1[i];
            i++;
            k++;
        }

        // 5. Cleanup/Post-merge: If elements are left in arr2 (arr1 was exhausted first)
        while (j < m) {
            mergedArray[k] = arr2[j];
            j++;
            k++;
        }

        return mergedArray;
    }

    /**
     * Helper function to print an array.
     */
    private static void printArray(String label, int[] arr) {
        System.out.print(label + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Test Case 1: Standard merge
        int[] arrayA = {1, 3, 5, 7};
        int[] arrayB = {2, 4, 6, 8};
        int[] result1 = mergeSortedArrays(arrayA, arrayB);

        System.out.println("--- Test Case 1 ---");
        printArray("Array A", arrayA);
        printArray("Array B", arrayB);
        printArray("Merged Result", result1);
        // Expected Output: [1, 2, 3, 4, 5, 6, 7, 8]

        System.out.println("\n-------------------\n");

        // Test Case 2: Unequal lengths and overlapping elements
        int[] arrayC = {10, 20, 30};
        int[] arrayD = {5, 15, 25, 35, 45};
        int[] result2 = mergeSortedArrays(arrayC, arrayD);

        System.out.println("--- Test Case 2 ---");
        printArray("Array C", arrayC);
        printArray("Array D", arrayD);
        printArray("Merged Result", result2);
        // Expected Output: [5, 10, 15, 20, 25, 30, 35, 45]

        System.out.println("\n-------------------\n");

        // Test Case 3: Empty array check
        int[] arrayE = {100, 200};
        int[] arrayF = {};
        int[] result3 = mergeSortedArrays(arrayE, arrayF);

        System.out.println("--- Test Case 3 (One Empty Array) ---");
        printArray("Array E", arrayE);
        printArray("Array F", arrayF);
        printArray("Merged Result", result3);
        // Expected Output: [100, 200]
    }
}
