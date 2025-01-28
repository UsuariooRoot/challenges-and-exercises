/**
 * Created: 2025-01-27
 * Author: UoRoot
 * Problem:
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;

        for (int i = 0, j = needle.length(); j <= haystack.length(); j++)
            if (needle.equals(haystack.substring(i++, j)))
                return i - 1;

        return -1;
    }

}