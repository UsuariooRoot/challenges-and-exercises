/**
 * Created: 2025-04-24
 * Author: UoRoot
 * Problem:
 * https://leetcode.com/problems/count-the-hidden-sequences
 */
public class CountTheHiddenSequences {

    // Time Limit Exceeded
    public static int numberOfArraysFailed(int[] differences, int lower, int upper) {
        int res = 0;
        int[] hidden = new int[differences.length + 1];
        boolean into = false;

        for (int i = lower; i <= upper; i++) {
            int idx = 0;
            hidden[idx] = i;
            boolean valid = true;
            for (int j : differences) {
                hidden[idx + 1] = j + hidden[idx];
                idx++;
                valid = hidden[idx] >= lower && hidden[idx] <= upper;
                if (!valid)
                    break;
            }

            if (!valid && into)
                break;
            if (valid) {
                res++;
                into = true;
            }
        }

        return res;
    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int res = 0;
        int[] hidden = new int[differences.length + 1];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        hidden[0] = lower;

        if (hidden[0] < min) {
            min = hidden[0];
        }

        if (hidden[0] > max) {
            max = hidden[0];
        }

        for (int i = 0; i < differences.length; i++) {
            hidden[i + 1] = differences[i] + hidden[i];
            if (hidden[i + 1] < min) {
                min = hidden[i + 1];
            } else if (hidden[i + 1] > max) {
                max = hidden[i + 1];
            }
        }

        max += Math.abs(lower - min);
        lower = Math.max(lower, min);

        for (int i = lower; i <= upper; i++) {
            if (!(max >= lower && max <= upper))
                break;
            res++;
            max++;
        }

        return res;
    }

}