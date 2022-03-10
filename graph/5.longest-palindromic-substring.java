/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public boolean inlimit(int a,int b,int n){
        return a<n && b<n && a<=b;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean pal[][] = new boolean[n][n];
        for(int i=0;i<n;i++){
            pal[i][i] = true;
        }
        int c=1;
        while(c<n){
            int i=0;
            int j=c;
            while(i<n && j<n){
                if(s.charAt(i) == s.charAt(j) ){
                    if(inlimit(i+1, j-1, n)){
                        pal[i][j] = pal[i+1][j-1];
                    }
                    else{
                        pal[i][j] = true;
                    }
                }
                else{
                    pal[i][j] = false;
                }
                i++;
                j++;
            }
            c++;
        }
        int max = 0;
        int start=0; int end=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(pal[i][j] && (j-i+1) > max){
                    start = i;
                    end = j;
                    max = Math.max(max, (j-i+1));
                }
            }
        }
        return s.substring(start, end+1);
    }
}
// @lc code=end

