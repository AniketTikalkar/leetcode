public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[c] = nums[i];
                c++;
            }
        }

        while (c < nums.length) {
            nums[c] = 0;
            c++;
        }
    }

    public static void main(String[] args) {
        /**
         * Given an integer array nums, move all 0's to the end of it while maintaining
         * the relative order of the non-zero elements.
         */
    }
}
