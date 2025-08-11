package ExceriseCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableArrayListExample {
    public static void main(String[] args) {
        // Create a modifiable ArrayList
        ArrayList<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Cherry");

        System.out.println("Original List: " + originalList);

        // Get an unmodifiable view of the originalList
        List<String> unmodifiableView = Collections.unmodifiableList(originalList);

        System.out.println("Unmodifiable View: " + unmodifiableView);

        // Attempting to modify the unmodifiable view will throw an UnsupportedOperationException
        try {
            unmodifiableView.add("Date"); // This will fail
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the unmodifiable view directly.");
        }

        // IMPORTANT: Changes to the original list ARE reflected in the unmodifiable view
        originalList.add("Elderberry");
        System.out.println("Original List after modification: " + originalList);
        System.out.println("Unmodifiable View after original list modification: " + unmodifiableView);
    }
}
