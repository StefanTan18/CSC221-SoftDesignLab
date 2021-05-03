import java.util.Stack;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Stack<Character> stackChar = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();

        IntStream.rangeClosed(65, 90).forEach(i -> stackChar.add((char) i));
        IntStream.rangeClosed(1, 5).forEach(stackInt::add);

        StackOperations stackOperations = new StackOperations();

        stackOperations.toQueue(stackChar).forEach(System.out::print);
        System.out.println();
        stackOperations.reverseStack(stackChar).forEach(System.out::print);
        System.out.println();
        System.out.print(stackOperations.sumBetween(stackInt, 20, 3));
        System.out.println();
        stackInt.clear();
        IntStream.rangeClosed(1, 5).forEach(stackInt::add);
        System.out.print(stackOperations.sumBetween(stackInt, 0, 3));// 10 = 1 2 3 4
        System.out.println();
        stackInt.clear();
        IntStream.rangeClosed(1, 5).forEach(stackInt::add);
        System.out.print(stackOperations.sumBetween(stackInt, 0, 4));// 15 = 1 2 3 4 5
        System.out.println();
        stackOperations.readNumericFromFile("TestFile.txt").forEach(System.out::print);
    }
}
