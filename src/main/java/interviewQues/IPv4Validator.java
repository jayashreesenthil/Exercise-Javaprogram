package interviewQues;

import java.util.Scanner;

public class IPv4Validator {
    public static void main(String[] args) {
         String IPV4_REGEX =
                "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";

        //String s = "192.168.1.1";
        //user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP Address to validate: ");
        String s = sc.nextLine();
        if(s == null || s.isEmpty()){
            System.out.println(false);
            return;
        }
        System.out.println(s.matches(IPV4_REGEX));
    }
}
