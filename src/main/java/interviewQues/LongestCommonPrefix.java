package interviewQues;

public class LongestCommonPrefix {
//    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
//        if (strs == null || strs.length == 0) {
//            return;
//        }
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++) {
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) {
//                    return;
//                }
//            }
//        }
//        System.out.println("Longest Common Prefix: " + prefix);
//    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String currentString = strs[i];
            while (!currentString.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcpFinder = new LongestCommonPrefix();

        String[] example1 = {"flower", "flow", "flight"};
        String result1 = lcpFinder.longestCommonPrefix(example1);
        System.out.println("Input: {\"flower\", \"flow\", \"flight\"}");
        System.out.println("LCP: " + result1); // Output: fl

        System.out.println("---");

        String[] example2 = {"dog", "racecar", "car"};
        String result2 = lcpFinder.longestCommonPrefix(example2);
        System.out.println("Input: {\"dog\", \"racecar\", \"car\"}");
        System.out.println("LCP: " + result2); // Output:

        System.out.println("---");

        String[] example3 = {"java", "javascript", "jargon"};
        String result3 = lcpFinder.longestCommonPrefix(example3);
        System.out.println("Input: {\"java\", \"javascript\", \"jargon\"}");
        System.out.println("LCP: " + result3); // Output: ja
    }
}
