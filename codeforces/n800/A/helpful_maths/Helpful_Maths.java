package n800.A.helpful_maths;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Helpful_Maths {
    public static void main(String[] args) {
        long time = System.nanoTime();
        try (Scanner scanner = new Scanner(System.in);) {
            String input = scanner.next();
            System.out.println(solve2(input)); // You can choosing any so
        }
        System.out.println(time);
    }

    public static String solve1(String input) {
        if (input.length() <= 2)
            return input;
        String output = Arrays.stream(input.split("\\+"))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining("+"));
        return output;
    }

    public static String solve2(String input) {
        int length = input.length();
        if (length <= 2)
            return input;

        StringBuilder numbers1 = new StringBuilder();
        StringBuilder numbers2 = new StringBuilder();
        StringBuilder numbers3 = new StringBuilder();

        int i = 0;
        while (i < length) {
            char current = input.charAt(i);
            if (current == "3".charAt(0)) {
                numbers3.append(current+"+");
            } else if (current == "2".charAt(0)) {
                numbers2.append(current+"+");
            } else {
                numbers1.append(current+"+");
            }
            i+=2;
        }
        return (numbers1.toString() + numbers2 + numbers3).substring(0, length);
    }
}
