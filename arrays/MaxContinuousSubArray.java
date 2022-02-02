import java.util.Arrays;

public class MaxContinuousSubArray {
    // kadane's algo
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // track sum till the index
        int max_ending_here = 0;
        // track the subarray
        int max_so_far = 0;

        // incase if update never reached, that is all elements are negative
        boolean allNeg = true;
        for (int i = 0; i < n; i++) {
            max_ending_here += nums[i];
            // just reset range
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
            // if adding curr element is increasing tracked maximum, update the tracking
            // maximum
            else if (max_ending_here > max_so_far) {
                allNeg = false;
                max_so_far = max_ending_here;
            }
        }
        // if all ele were negative,then get maximum number, will work for 0 as well
        if (allNeg) {
            max_so_far = Arrays.stream(nums).max().getAsInt();
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        /**
         * Given an integer array nums, find the contiguous subarray (containing at
         * least one number) which has the largest sum and return its sum.
         */
    }
}
