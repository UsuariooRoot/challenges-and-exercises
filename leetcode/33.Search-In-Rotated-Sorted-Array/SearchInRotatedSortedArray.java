public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (target < nums[left] && target > nums[right])
            return -1;

        if (nums[left] > nums[right]) {
            while (left <= right) {
                int middle = (left + right) / 2;

                if (nums[left] >= nums[middle]) {
                    left = middle;
                    break;
                }

                left = middle + 1;
            }

            int idx = left;
            while (nums[idx] < nums[0])
                idx--;

            if (target >= nums[0]) {
                left = 0;
                right = idx;
            } else {
                left = idx + 1;
            }
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid])
                return mid;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (target < nums[left] && target > nums[right])
            return -1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target == nums[middle])
                return middle;

            if (nums[middle] >= nums[left]) {
                if (target >= nums[left] && target <= nums[middle])
                    right = middle - 1;
                else
                    left = middle + 1;
            } else {
                if (target >= nums[middle] && target <= nums[right])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
        }

        return -1;
    }
}
