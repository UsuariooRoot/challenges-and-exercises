import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created: 2025-01-26
 * Author: UoRoot
 * Problem: https://leetcode.com/problems/check-if-n-and-its-double-exist
 */
public class CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Byte> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                continue;
            int duplicated = arr[i] * 2;
            if (map.containsKey(duplicated))
                return true;
            for (int j = i + 1; j < arr.length; j++) {
                if (duplicated == arr[j])
                    return true;
            }
            map.put(arr[i], null);
        }

        return false;
    }

    public boolean checkIfExist2(int[] arr) {
        Set<Integer> map = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.contains(arr[i] * 2) || arr[i] % 2 == 0 && map.contains(arr[i] / 2))
                return true;
            map.add(arr[i]);
        }

        return false;
    }

    public boolean checkIfExist3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int doubled = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (i != j && doubled == arr[j]) return true;
            }
        }
        return false;
    }

}