import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String item = i % 3 == 0
                    ? (i % 5 == 0 ? "FizzBuzz" : "Fizz")
                    : i % 5 == 0
                            ? "Buzz"
                            : Integer.toString(i);
            answer.add(item);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
    }
}