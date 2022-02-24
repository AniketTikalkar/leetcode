/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int cal(TreeNode root){
        if(root ==null){
            return Integer.MAX_VALUE;
        }
        //means you're looking at a leaf
        int min = Math.min(cal(root.left),cal(root.right));
        //reset min to 0 for leaf
        if(min == Integer.MAX_VALUE){
            min=0;
        }
        return  min+ 1;
    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return cal(root);
    }
}
// @lc code=end

