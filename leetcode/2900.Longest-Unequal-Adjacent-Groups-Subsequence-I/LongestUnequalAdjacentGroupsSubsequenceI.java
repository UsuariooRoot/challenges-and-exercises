import java.util.ArrayList;
import java.util.List;

/**
 * Created: 2025-05-15
 * Author: UoRoot
 * Problem:
 * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i
 */
public class LongestUnequalAdjacentGroupsSubsequenceI {

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        int prevGroupValue = -1;

        for (int i = 0; i < groups.length; i++) {
            if (prevGroupValue != groups[i]) {
                prevGroupValue = groups[i];
                res.add(words[i]);
            }
        }
        return res;
    }

}