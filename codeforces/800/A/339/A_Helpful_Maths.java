import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created: 2025-01-22
 * Author: UoRoot
 */
public class A_Helpful_Maths {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            String input = scanner.next();
            System.out.println(solve(input)); // You can choosing any so
        }
    }

    public static String solve(String input) {
        if (input.length() <= 2)
            return input;
        String output = Arrays.stream(input.split("\\+"))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining("+"));
        return output;
    }
}
