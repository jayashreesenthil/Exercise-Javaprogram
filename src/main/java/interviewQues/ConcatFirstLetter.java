package interviewQues;

public class ConcatFirstLetter {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Cherry", "Date"};
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word != null && !word.isEmpty()) {
                result.append(word.charAt(0));
            }
        }

        System.out.println("Concatenated first letters: " + result);


        String input = "hello world";
        StringBuilder output = new StringBuilder();
        String[] tokens = input.trim().split("\\s+");
        for (String token : tokens) {
            for (int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                if (Character.isLetter(c)) {
                   output.append(c);
                  //  output.append(Character.toUpperCase(c)); //- to capitalize first letter
                    break;
                }
            }
        }
        System.out.println("Output: " + output);
    }
}