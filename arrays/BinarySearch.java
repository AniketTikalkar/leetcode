public class BinarySearch {
    public int search(int[] nums, int target) {
        int h = nums.length - 1;
        int l = 0;
        int ans = -1;
        while (h >= l) {
            int m = (h + l) / 2;
            if (nums[m] == target) {
                ans = m;
                break;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * Given an array of integers nums which is sorted in ascending order, and an
         * integer target, write a function to search target in nums. If target exists,
         * then return its index. Otherwise, return -1.
         */
    }
}
