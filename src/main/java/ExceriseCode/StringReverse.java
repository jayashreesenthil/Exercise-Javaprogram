package ExceriseCode;

import java.util.*;

public class StringReverse {
    public static void main(String[] args) {

        System.out.println("jayashree".substring(0, 1).toUpperCase());
        System.out.println("jayashree".substring(1));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = input.nextLine();
//        String s= name.substring(1);
//        String ss= name.substring(0, 1);
//        System.out.println("String: "+s  +ss);
        String capitalized = name.substring(0, 1).toUpperCase() + name.substring(1);
        System.out.println(capitalized);
        for (int i = name.length() - 1; i >= 0; --i) {
            System.out.print(name.charAt(i));
        }

        // Remove duplicates and reverse the list of Strings
        List<String> list1 = Arrays.asList("a", "b", "c", "a", "e", "b", "d");
        List<String> uniqueList = list1.stream().distinct().toList().reversed();
        System.out.println("List without duplicates: " + uniqueList);

        // Remove duplicates and reverse the list of integers
        List<Integer> list2 = Arrays.asList(1, 2, 3, 1, 4, 2, 5);
        List<Integer> uniqueList1 = list2.stream().distinct().toList().reversed();
        System.out.println("List without duplicates: " + uniqueList1);
    }
}
