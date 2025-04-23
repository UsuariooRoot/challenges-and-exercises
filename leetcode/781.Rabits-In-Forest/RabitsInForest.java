import java.util.HashMap;

public class RabitsInForest {

    public static int numRabbits(int[] answers) {
        HashMap<Integer, Integer> numRabitsMap = new HashMap<>();
        int res = 0;

        for (int n : answers) {
            if (n == 0) {
                res++;
            } else {
                var val = numRabitsMap.get(n);
                if (val != null) {
                    if (val + 1 > n) {
                        numRabitsMap.remove(n);
                    } else {
                        numRabitsMap.replace(n, val + 1);
                    }
                } else {
                    numRabitsMap.put(n, 1);
                    res += n + 1;
                }
            }
        }
        return res;
    }

}