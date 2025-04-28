/**
 * Created: 2025-04-27
 * Author: UoRoot
 * Problem:
 * https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition
 */
public class CountSubarraysOfLengthThreeWithACondition {

    // Input: nums = [1,2,1,4,1]
    // Output: 1
    public static int countSubarrays(int[] nums) {
        int res = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            double a = nums[i], b = nums[i+1], c = nums[i + 2];
            if (a + c == b / 2) {
                res++;  
            }
        }

        return res;
    }

    // [1,0,1]
    // [0,-4,-4]
    // [-1,-4,-1,4]
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] {1,2,1,4,1}));
        System.out.println(countSubarrays(new int[] {1, 3, 6, 0, -2, -4}));
        System.out.println(countSubarrays(new int[] {1, 0, 1}));
        System.out.println(countSubarrays(new int[] {0, -4, -4}));
        System.out.println(countSubarrays(new int[] {-1, -4, -1, 4}));
        
    }
}