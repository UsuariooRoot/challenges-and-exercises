import java.util.Arrays;

/**
 * Created: 2024-12-30
 * Author: UoRoot
 */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteChars = ransomNote.toCharArray();
        Arrays.sort(ransomNoteChars);
        char[] magazineChars = magazine.toCharArray();
        Arrays.sort(magazineChars);

        int i = 0;
        int j = 0;
        while (i < ransomNoteChars.length && j < magazineChars.length) {
            char c1 = magazineChars[j];
            char c2 = ransomNoteChars[i];
            if (c1 == c2) {
                i++;
                j++;
                continue;
            }

            if (c1 < c2) {
                j++;
                continue;
            }

            if (c1 > c2)
                return false;

        }

        return i == ransomNoteChars.length;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        int[] alphabetCounter = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            alphabetCounter[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            alphabetCounter[magazine.charAt(i) - 'a']--;
        }

        for (int i : alphabetCounter) {
            if (i > 0)
                return false;
        }

        return true;
    }

    public static boolean canConstruct3(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        int[] alphabetCounter = new int[26];

        for (int c : magazine.toCharArray()) {
            alphabetCounter[c - 'a']++;
        }

        for (int c : ransomNote.toCharArray()) {
            if (alphabetCounter[c - 'a'] == 0)
                return false;
            alphabetCounter[c - 'a']--;
        }

        return true;
    }

}
