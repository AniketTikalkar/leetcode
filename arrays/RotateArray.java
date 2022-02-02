public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];
        k = k % n;
        for (int i = 0; i < n; i++) {
            int i2 = (i + k) % n;
            ans[i2] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }

    public static void main(String[] args) {
        /**
         * Given an array, rotate the array to the right by k steps, where k is
         * non-negative.
         */
    }
}
