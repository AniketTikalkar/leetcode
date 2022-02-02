public class SortedTwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n - 1;
        while (i != j) {
            if ((numbers[i] + numbers[j]) == target) {
                break;
            } else if ((numbers[i] + numbers[j]) > target) {
                j--;
            } else {
                i++;
            }
        }
        int arr[] = new int[2];
        arr[0] = i + 1;
        arr[1] = j + 1;
        return arr;

    }

    public static void main(String[] args) {
        /**
         * Given a 1-indexed array of integers numbers that is already sorted in
         * non-decreasing order, find two numbers such that they add up to a specific
         * target number. Let these two numbers be numbers[index1] and numbers[index2]
         * where 1 <= index1 < index2 <= numbers.length.
         */
    }
}
