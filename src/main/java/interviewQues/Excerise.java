package interviewQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

    static class SimpleIntervalMerger {

        public int[][] merge(int[][] intervals, int[] newInterval) {

            // 1. Initialize the result list.
            List<int[]> merged = new ArrayList<>();

            // 2. Add the new interval to the existing list to treat them all uniformly.
            // Convert to a list of lists/arrays for easy manipulation.
            List<int[]> allIntervals = new ArrayList<>(Arrays.asList(intervals));
            allIntervals.add(newInterval);

            // 3. Sort all intervals by their start time. This is CRUCIAL for merging.
            // {{-3,-3}, {1,3}, {4,6}, {16,92}, {2,10}} -> Sorted: {{-3,-3}, {1,3}, {2,10}, {4,6}, {16,92}}
            allIntervals.sort(Comparator.comparingInt(a -> a[0]));

            // 4. Start the merging process with the first interval.
            int[] currentInterval = allIntervals.get(0);
            merged.add(currentInterval); // Add the first one, it will be compared against the rest

            // 5. Iterate through the rest of the sorted intervals (starting from index 1).
            for (int i = 1; i < allIntervals.size(); i++) {
                int[] next = allIntervals.get(i);

                // Get the current interval from the end of the merged list.
                // (Note: This is an equivalent logic to the one above, but perhaps easier to read)
                currentInterval = merged.get(merged.size() - 1);

                // Check for overlap: current_end >= next_start
                if (currentInterval[1] >= next[0]) {
                    // MERGE: Overlap found, update the end of the current interval.
                    // The start remains the same, the end is the maximum of the two ends.
                    currentInterval[1] = Math.max(currentInterval[1], next[1]);
                } else {
                    // NO OVERLAP: Add the next interval to the result as a new, distinct interval.
                    merged.add(next);
                }
            }

            // 6. Convert the List<int[]> back to int[][] array.
            return merged.toArray(new int[merged.size()][]);
        }

        public static void main(String[] args) {
            int[][] intervals = {{-3, -3}, {1, 3}, {4, 6}, {16, 92}};
            int[] newInterval = {2, 10};

            SimpleIntervalMerger merger = new SimpleIntervalMerger();
            int[][] result = merger.merge(intervals, newInterval);

            System.out.println("Merged Intervals: " + Arrays.deepToString(result));
            // Output: Merged Intervals: [[-3, -3], [1, 10], [16, 92]]
        }
    }
}
