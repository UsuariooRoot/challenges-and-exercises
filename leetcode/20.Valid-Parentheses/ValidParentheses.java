import java.util.Map;

/**
 * Created: 2025-01-19
 * Author: UoRoot
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        Map<Character, Character> openChars = Map.of(
                '}', '{',
                ')', '(',
                ']', '[');

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (openChars.containsKey(c)) {
                int delIndex = sb.length()-1;
                if (delIndex < 0) return false;
                if (openChars.get(c).charValue() != sb.charAt(delIndex))
                    return false;
                sb.deleteCharAt(delIndex);
            } else {
                sb.append(c);
            }
        }

        return sb.length() == 0;
    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 == 1)
            return false;

        Boolean res = true;
        backtrak(s.toCharArray(), 0, 0, res);

        return res;
    }

    private static void backtrak(char[] s, int i, int j, Boolean res) {
        if (j >= s.length) return;
        if (!res) return;
        if (s[j] == '(' || s[j] == '[' || s[j] == '{') {
            backtrak(s, i++, j++, res);
        } else {
            if (s[j] == ')' && s[i] != '(') {
                res = false;
            } else if (s[j] == ']' && s[i] != '[') {
                res = false;
            } else if (s[j] == '}' && s[i] != '{') {
                res = false;
            } else {
                backtrak(s, i, j++, res);
            }
        }
    }
    
}