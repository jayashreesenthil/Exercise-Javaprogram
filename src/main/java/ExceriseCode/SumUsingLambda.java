package ExceriseCode;

public class SumUsingLambda {

    @FunctionalInterface
    interface Sum {
        int add(int a, int b);
    }

    public static void main(String[] args) {
        Sum sum = (a, b) -> a + b;
        int result = sum.add(5, 10);
        System.out.println("Sum: " + result);
    }
}
