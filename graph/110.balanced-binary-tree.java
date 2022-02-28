import java.util.HashMap;

/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int[] heightBal(TreeNode root){
        int res[] = new int[2];
        if(root == null){
            //height
            res[0] = 0;
            //true
            res[1] = 1;
            return res;
        }
        int r[] = heightBal(root.right);
        int l[] = heightBal(root.left);
        res[0] = Math.max(l[0], r[0]) + 1;
        if(l[1] == 1 && r[1] ==1 && checkdiff(l[0],r[0])){
            res[1] = 1;
            return res;
        }
        res[1] = 0;
        return res;

    }
   
    public boolean checkdiff(int a,int b){
        return Math.abs(a-b) <=1;
    }
    public boolean isBalanced(TreeNode root) {

        return heightBal(root)[1]==1;
    }
}
// @lc code=end

