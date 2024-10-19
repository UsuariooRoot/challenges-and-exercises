public class Solution {  
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        int idx = 0;
        boolean isNegative = s.charAt(idx) == '-';

        if (s.charAt(idx) == '-' || s.charAt(idx) == '+') idx++;
        
        StringBuilder sb = new StringBuilder();

        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            char cur = s.charAt(idx++);
            
            if (sb.length() > 10) break;
            if (sb.length() > 0 || cur != '0') sb.append(cur);
        }

        String result = sb.toString();
        if (result.length() < 1) return 0;
        if (Long.valueOf(result) > Integer.MAX_VALUE) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return isNegative ? -1 * Integer.valueOf(result): Integer.valueOf(result);
    }
}