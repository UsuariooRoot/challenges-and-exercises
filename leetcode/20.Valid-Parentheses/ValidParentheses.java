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

}