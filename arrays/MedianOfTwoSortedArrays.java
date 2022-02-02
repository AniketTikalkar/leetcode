public class MedianOfTwoSortedArrays {
    /*
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
     * the median of the two sorted arrays.
     * 
     * The overall run time complexity should be O(log (m+n)).
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int median_index = (m + n) / 2;

        int i = 0, j = 0;
        // this is the order we are chasing
        int count = 0;
        while (count > 0) {
            // int prev_count = count;
            if (nums2[j] >= nums1[i]) {
                int pos_ind = runBinarySearchRecursively(nums1, nums2[j], i, m - 1);
                count += pos_ind;
                if (count >= median_index) {
                    // nums1[i+ median_index - prev_count];
                }
                i += pos_ind;
                j++;
            } else {
                int pos_ind = runBinarySearchRecursively(nums2, nums1[i], j, n - 1);
                count += pos_ind;
                if (count >= median_index) {
                    // nums2[j + median_index - prev_count];
                }
                j += pos_ind;
                i++;
            }
        }
        return 0;
    }

    public static int runBinarySearchRecursively(
            int[] sortedArray, int key, int low, int high) {
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return runBinarySearchRecursively(
                    sortedArray, key, low, middle - 1);
        } else {
            return runBinarySearchRecursively(
                    sortedArray, key, middle + 1, high);
        }
    }

    public static void main(String[] args) {
        // double ans = findMedianSortedArrays();
    }
}
