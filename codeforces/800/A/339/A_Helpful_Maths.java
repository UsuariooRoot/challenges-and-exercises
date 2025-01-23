import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created: 2025-01-22
 * Author: UoRoot
 */
public class A_Helpful_Maths {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            String input = scanner.next();
            System.out.println(solve2(input));
        }
    }

    public static String solve(String input) {
        if (input.length() <= 2)
            return input;
        String output = Arrays.stream(input.split("\\+"))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining("+"));
        return output;
    }

    public static String solve2(String input) {
        if (input.length() <= 2)
            return input;
        
        StringBuilder sb = new StringBuilder(input);
        dualPivotQuickSortAdapted(sb, 0, sb.length() - 1);
        return sb.toString();
    }

    private static void dualPivotQuickSortAdapted(StringBuilder arr, int left, int right) {
        if (right <= left) return;
        
        if (arr.charAt(left) > arr.charAt(right)) {
            swap(arr, left, right);
        }
        
        int pivot1 = arr.charAt(left) - 48;
        int pivot2 = arr.charAt(right) - 48;
        
        int l = left + 2;
        int k = l;
        int g = right - 2;
        
        while (k <= g) {
            if (arr.charAt(k) - 48 < pivot1) {
                swap(arr, k, l);
                l+=2;
            } 
            else if (arr.charAt(k) - 48 > pivot2) {
                while (arr.charAt(g) - 48 > pivot2 && k < g) {
                    g-=2;
                }
                swap(arr, k, g);
                g-=2;
                if (arr.charAt(k) - 48 < pivot1) {
                    swap(arr, k, l);
                    l+=2;
                }
            }
            k+=2;
        }
        l-=2;
        g+=2;
        
        swap(arr, left, l);
        swap(arr, right, g);
        
        dualPivotQuickSortAdapted(arr, left, l - 2);
        dualPivotQuickSortAdapted(arr, l + 2, g - 2);
        dualPivotQuickSortAdapted(arr, g + 2, right);
    }

    private static void swap(StringBuilder arr, int i, int j) {
        char temp = arr.charAt(i);
        arr.setCharAt(i, arr.charAt(j));
        arr.setCharAt(j, temp);
    }
}
