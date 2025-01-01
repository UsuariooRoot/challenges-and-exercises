import java.util.HashMap;

public class RomanToInteger {

    public static int romanToInt(String s) {
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        char[] letters = s.toCharArray();
        int i = 0;
        int res = 0;
        while (i < letters.length) {
            int c1 = values.get(letters[i]);
            if (i == letters.length - 1) {
                res += c1;
                break;
            }

            int c2 = values.get(letters[++i]);

            if (c1 >= c2) {
                res += c1;
            } else {
                res += c2 - c1;
                i++;
            }
        }

        return res;
    }

    public static int romanToInt2(String s) {
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        char[] letters = s.toCharArray();
        int res = values.get(letters[letters.length - 1]);
        for (int i = letters.length - 2; i >= 0; i--) {
            int value = values.get(letters[i]);
            if (value < values.get(letters[i + 1])) {
                res -= value;
            } else {
                res += value;
            }
        }

        return res;
    }
}