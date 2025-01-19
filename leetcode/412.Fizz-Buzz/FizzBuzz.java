import java.util.ArrayList;
import java.util.List;

/**
 * Created: 2024-12-27
 * Author: UoRoot
 */
public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            answer.add(
                i % 15 == 0 ? "FizzBuzz"
                : i % 3 == 0 ? "Fizz" 
                : i % 5 == 0 ? "Buzz"
                : Integer.toString(i)
            );
        }

        return answer;
    }

}