public class MaximumScoreAfterSplittingAString {

    public static int maxScore(String s) {
        int max = -1;
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            int sum = countCharacters(left, '0') + countCharacters(right, '1');
            if (sum > max)
                max = sum;
        }
        return max;
    }

    private static int countCharacters(String str, char character) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == character)
                count++;
        }
        return count;
    }

    public static int maxScore2(String s) {
        int left = s.charAt(0) == '0' ? 1: 0;
        int right = countCharacters(s.substring(1), '1');
        int max = left + right;

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0')
                left++;
            else
                right--;

            max = Math.max(max, left + right);
        }

        return max;
    }

}
