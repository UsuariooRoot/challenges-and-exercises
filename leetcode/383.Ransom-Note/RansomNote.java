import java.util.Arrays;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        char[] ransomNoteChars =  ransomNote.toCharArray();
        Arrays.sort(ransomNoteChars);
        char[] magazineChars =  magazine.toCharArray();
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

            if (c1 > c2) return false;

        }

        return i == ransomNoteChars.length;
    }
}

