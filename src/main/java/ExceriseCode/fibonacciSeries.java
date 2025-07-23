package ExceriseCode;

public class fibonacciSeries {

        public static void main(String[] args) {
            int count = 10; // Number of terms to display

            // Initialize the first two terms
            int a = 0;
            int b = 1;

            System.out.println("Fibonacci series up to " + count + " terms:");

            // Print the first two terms
            System.out.print(a + " " + b + " ");

            // Generate and print the remaining terms
            for (int i = 2; i < count; i++) {
                //int nextTerm = a + b;
                System.out.print(b + " ");
                a = b;
                b = a + b;
            }
        }

}
