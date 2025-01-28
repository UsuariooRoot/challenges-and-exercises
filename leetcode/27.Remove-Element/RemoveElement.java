import java.util.Arrays;

/**
 * Created: 2025-01-28
 * Author: UoRoot
 * Problem: https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int idx = 1;

        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i])
                nums[idx++] = nums[i];
        }

        if (idx < nums.length)
            Arrays.fill(nums, idx, nums.length - 1, 0);

        return idx;
    }

}