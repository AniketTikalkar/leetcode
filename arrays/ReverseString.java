public class ReverseString {
    public void reverseString(char[] s) {
        int n = s.length;
        int i = 0;
        int j = n - 1;
        while (j > i) {
            char x = s[i];
            s[i] = s[j];
            s[j] = x;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        /**
         * Write a function that reverses a string. The input string is given as an
         * array of characters s.
         * 
         * You must do this by modifying the input array in-place with O(1) extra
         * memory.
         */
    }
}
