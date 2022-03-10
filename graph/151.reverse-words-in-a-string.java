/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String ans = "";
        String[] str = s.trim().split(" ");
        for(int j=str.length-1;j>=0;j--){
            if(!str[j].equals("")){
                ans += str[j] + " ";
            }
        }
        return ans.trim();
    }
}
// @lc code=end

