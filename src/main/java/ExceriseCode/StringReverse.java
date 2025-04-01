package ExceriseCode;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {

        System.out.println("jayashree".substring(0,1).toUpperCase());
        System.out.println("jayashree".substring(1));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = input.nextLine();
//        String s= name.substring(1);
//        String ss= name.substring(0, 1);
//        System.out.println("String: "+s  +ss);
            String capitalized = name.substring(0, 1).toUpperCase() + name.substring(1);
        System.out.println(capitalized);
        for(int i=name.length()-1;i>=0;--i){
            System.out.print(name.charAt(i));
        }

    }
}
