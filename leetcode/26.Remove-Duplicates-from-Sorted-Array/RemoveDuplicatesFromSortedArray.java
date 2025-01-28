import java.util.Arrays;

/**
 * Created: 2025-01-27
 * Author: UoRoot
 * Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int idx = 1;
        
        for (int i = 1; i < nums.length; i++) {            
            if (nums[i] != nums[i-1]) {
                nums[idx++] = nums[i];
            }
        }
        
        if (nums.length > 1 && idx < nums.length)
            Arrays.fill(nums, idx, nums.length - 1, 0);

        return idx;
    }

}