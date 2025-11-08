package interviewQues;

public class InfiniteRecursion {
    public static void main(String[] args) {
        recursiveMethod();
    }

    public static void recursiveMethod() {
        System.out.println("Calling recursiveMethod again...");
        recursiveMethod(); // Infinite recursive call
    }
}
