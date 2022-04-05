import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<s.length();i++){
            
            if(!stack.empty() && ((s.charAt(i) == ']' && stack.peek() == '[') || (s.charAt(i) == '}' && stack.peek() == '{') || (s.charAt(i) == ')' && stack.peek() == '('))){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

