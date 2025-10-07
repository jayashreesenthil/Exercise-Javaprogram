package ExceriseCode;

public class StringCompressor {

    public static String compress(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        int count = 1;
        char prev = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                result.append(prev).append(count);
                prev = curr;
                count = 1;
            }
        }
        result.append(prev).append(count); // append last group
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "aabbbccddddaa";
        System.out.println(compress(input)); // Output: a2b3c2a2
    }
}
