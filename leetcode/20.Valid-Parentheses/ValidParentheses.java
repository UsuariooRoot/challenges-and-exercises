/**
 * Created: 2025-01-19
 * Author: UoRoot
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        char[] sc = s.toCharArray();
        StringBuilder sb = new StringBuilder().append(sc[0]);
        for (int i = 1; i < sc.length; i++) {
            if (sc[i] == '(' || sc[i] == '[' || sc[i] == '{') {
                sb.append(sc[i]);
            } else {
                int delIndex = sb.length() - 1;
                if (delIndex > -1 && (sc[i] == ')' && sb.charAt(delIndex) == '(' ||
                        sc[i] == ']' && sb.charAt(delIndex) == '[' ||
                        sc[i] == '}' && sb.charAt(delIndex) == '{')) {
                    sb.deleteCharAt(delIndex);
                } else
                    return false;
            }
        }

        return sb.length() == 0;
    }

    public boolean isValid2(String s) {
        char[] arr = new char[s.length()];
        int i = -1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                arr[++i] = c;
            } else {
                if (i == -1)
                    return false;
                if (c == ')' && arr[i] != '(')
                    return false;
                if (c == ']' && arr[i] != '[')
                    return false;
                if (c == '}' && arr[i] != '{')
                    return false;
                i--;
            }
        }
        return i == -1;
    }

}
