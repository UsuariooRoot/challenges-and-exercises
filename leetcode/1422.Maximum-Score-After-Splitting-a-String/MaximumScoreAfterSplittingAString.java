public class MaximumScoreAfterSplittingAString {

    public int maxScore(String s) {
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

    private int countCharacters(String str, char character) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == character)
                count++;
        }
        return count;
    }

}
