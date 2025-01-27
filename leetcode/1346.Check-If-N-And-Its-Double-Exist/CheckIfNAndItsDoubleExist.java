import java.util.HashMap;
import java.util.Map;

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

}