import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
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
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if(p.length() > s.length()){
            return res;
        }
        int p1 =0;
        int p2=0;
        int strp[] = new int[26];
        int temp[] = new int[26];
        for(int i=0;i<p.length();i++){
            strp[p.charAt(i)-'a']++;
        }
        while(p2 < p.length()){
            temp[s.charAt(p2)-'a']++;
            p2++;
        }
        
        while(p1 < p2 && p2 < s.length()){
            if(compare(strp, temp)){
                res.add(p1);
            }
            temp[s.charAt(p1) - 'a']--;
            temp[s.charAt(p2)-'a']++;
            p1++;
            p2++;

        }
        if(compare(strp, temp)){
            res.add(p1);
        }
        return res;
    }
}
// @lc code=end

