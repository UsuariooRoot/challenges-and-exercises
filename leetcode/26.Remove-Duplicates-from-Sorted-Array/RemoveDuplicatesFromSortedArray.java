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

        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }

        return idx;
    }

}