import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < s.length()) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            } else {
                max = Math.max(max, i - j + 1);
                set.add(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
