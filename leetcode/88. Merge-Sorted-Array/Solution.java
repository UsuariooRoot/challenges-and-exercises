/**
 * Created: 2024-09-19
 * Author: UoRoot
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int position = binarySearch(nums1, 0, m - 1, nums2[i]);
            insertAndShift(nums1, m, position, nums2[i]);
            m++;
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return binarySearch(nums, left, mid - 1, target);
        }
    }

    private void insertAndShift(int[] nums, int end, int position, int value) {
        for (int i = end; i > position; i--) {
            nums[i] = nums[i - 1];
        }
        nums[position] = value;
    }
}