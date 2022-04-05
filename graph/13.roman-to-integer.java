import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public void fillRank(Map<Character,Integer> map){
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public int romanToInt(String s) {
        Map<Character,Integer> rank = new HashMap<>();
        fillRank(rank);
        int val =0;
        for(int i=0;i<s.length();i++){
            if((i+1) < s.length() && rank.get(s.charAt(i)) < rank.get(s.charAt(i+1))){
                val -= rank.get(s.charAt(i));
            }
            else{
                val += rank.get(s.charAt(i));
            }
        }
        return val;
    }
}
// @lc code=end

