import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        boolean dup[] = new boolean[n];
        ArrayList<Stack<Integer>> lastFalseoccur = new ArrayList<Stack<Integer>>();
        for(int i=0;i<26;i++){
            Stack<Integer> stack = new Stack<>();
            stack.add(-1);
            lastFalseoccur.add(stack);
        }
        //keep track of overall last false found 
        Stack<Integer> lastFalse = new Stack<>();
        lastFalse.add(-1);
        for(int i=0;i<n;i++){
            //if the char is already processed then continue
            if(dup[i]){
                continue;
            }
            else if((i+1)<n && s.charAt(i) == s.charAt(i+1)){
                dup[i] = true;
                dup[i+1] = true;
                continue;
            }
            else if(lastFalse.peek() != -1 && lastFalse.peek() <= lastFalseoccur.get(s.charAt(i)-'a').peek()){
                dup[i] = true;
                if(lastFalseoccur.get(s.charAt(i)-'a').peek() != -1){
                    //update and remove from stack
                    dup[lastFalseoccur.get(s.charAt(i)-'a').pop()] = true;
                    
                }
                //its possible that our lastFalse overall got true, we must handle this
                if(dup[lastFalse.peek()]){
                    lastFalse.pop();
                }
                continue;
                
            }
            dup[i] = false;
            lastFalse.add(i);
            lastFalseoccur.get(s.charAt(i)-'a').push(i);
        }
        String str = "";
        for(int i=0;i<n;i++){
            if(!dup[i]){
                str += s.charAt(i);
            }
        }
        return str;
    }
}
// @lc code=end

