public class ReverseWords {
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

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            char[] temp = arr[i].toCharArray();
            reverseString(temp);
            arr[i] = String.valueOf(temp);
        }
        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        /**
         * Given a string s, reverse the order of characters in each word within a
         * sentence while still preserving whitespace and initial word order.
         */
    }
}
