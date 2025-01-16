/**
 * Created: 2025-01-15
 * Author: UoRoot
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        int idx = 0;
        int pos = 0;

        while (idx < strs[pos].length()) {
            char c = strs[pos].charAt(idx);
            while (pos < strs.length
                    && idx < strs[pos].length()
                    && strs[pos].charAt(idx) == c) {
                pos++;
            }
            if (pos == strs.length) {
                idx++;
                pos = 0;
            } else
                break;
        }

        return strs[0].substring(0, idx);

    }

}