public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int n = nums.length;
        int ans[] = new int[n];
        while (i < n && nums[i] < 0) {
            i++;
        }
        int j = i - 1;
        int c = 0;
        while (j >= 0 && i < n) {
            if (Math.abs(nums[j]) <= nums[i]) {
                ans[c] = (int) Math.pow(nums[j], 2);
                c++;
                j--;
            } else {
                ans[c] = (int) Math.pow(nums[i], 2);
                c++;
                i++;
            }
        }
        while (j >= 0) {
            ans[c] = (int) Math.pow(nums[j], 2);
            c++;
            j--;
        }
        while (i < n) {
            ans[c] = (int) Math.pow(nums[i], 2);
            c++;
            i++;
        }
        return ans;

    }

    public static void main(String[] args) {
        /**
         * Given an integer array nums sorted in non-decreasing order, return an array
         * of the squares of each number sorted in non-decreasing order.
         */
    }
}
