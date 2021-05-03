import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StackOperations {

    /*
     * Converts from a stack to a Queue. The queue will be represented as a LinkedList
     */
    public static Queue<Character> toQueue(Stack<Character> stackOriginal) {
        Queue<Character> queueChar = new LinkedList<>();
        IntStream.range(0, stackOriginal.size())
                .forEach(x -> {
                    queueChar.add(stackOriginal.get(x));
                });
        return queueChar;
    }

    /*
     * Returns a stack with items reversed from the original stack
     */
    public static Stack<Character> reverseStack(Stack<Character> stackOriginal) {
        Stack<Character> charStack = new Stack<>();
        IntStream.range(0, stackOriginal.size())
                .forEach(x -> {
                    charStack.push(stackOriginal.get(stackOriginal.size() - x - 1));
                });
        return charStack;
    }

    /*
     * Returns the sum of integers between the start and end positions
     */
    public static int sumBetween(Stack<Integer> stack, int startPosition, int endPosition) {
        if (startPosition <= endPosition && startPosition >= 0 && endPosition < stack.size()) {
            int sum = IntStream.rangeClosed(startPosition, endPosition)
                    .map(x -> {
                        return stack.get(x);
                    })
                    .sum();
            return sum;
        }
        return -1;
    }

    /*
     * Reads from an input file and returns the characters that are integers from the file.
     * The function will read the lines from the file, extract the characters, filter non-numeric characters (i.e. not 0,1,...9),
     * and place these character numbers on a stack
     */
    public static Stack<Character> readNumericFromFile(final String filePath) {
        Stack<Character> charStack = new Stack<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(line -> {
                line.chars()
                    .filter(Character::isDigit)
                    .mapToObj(Character::toChars)
                    .forEach(charArr -> {
                        IntStream.range(0, charArr.length)
                            .forEach(i -> {
                                charStack.push(charArr[i]);
                            });
                    });
            });
        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
        return charStack;   
    }
}
