/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean compare(int[] a1,int[] a2){
        boolean val = true;
        for(int i=0;i<26;i++){
            if(a1[i] != a2[i]){
                val = false;
                break;
            }
        }
        return val;
    }
    public boolean checkInclusion(String s1, String s2) {
        int base[] = new int[26];
        for(int i=0;i<s1.length();i++){
            base[s1.charAt(i)-'a']++;
        }
        int ref[] = new int[26];
        int n = s2.length();
        int m = s1.length();
        int i=0;
        int j=0;
        while(j<n && j<m){
            ref[s2.charAt(j)-'a']++;
            j++;
        }
        
        while(i<n && j<n && i<j){
            if(compare(base, ref)){
                return true;
            }
            ref[s2.charAt(i)-'a']--;
            ref[s2.charAt(j)-'a']++;
            i++;
            j++;
        }
        //edge case if last element was permutation 
        if(compare(base, ref)){
            return true;
        }
        return false;
    }
}
// @lc code=end

