package ExceriseCode;

public class wordsCapitalize {
    public static void main(String[] args) {
        String input = "hello world from java";
        String[] words = input.split(" ");

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1));
            }
            result.append(" ");
        }
        System.out.println(result.toString().trim());

        StringBuilder capitalizedSentence = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1);
                capitalizedSentence.append(capitalizedWord).append(" ");
            }
        }  // Trim the trailing space and print the result
        System.out.println(capitalizedSentence.toString().trim());
    }
}
