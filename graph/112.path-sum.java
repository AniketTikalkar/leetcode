/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    public boolean func(TreeNode root, int targetSum){
        if(root == null ){
            return false;
        }
        if(isLeaf(root) && root.val == targetSum){
            return true;
        }
        return func(root.left, targetSum-root.val) || func(root.right, targetSum - root.val);
    }
    public boolean isLeaf(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return func(root, targetSum);
    }
}
// @lc code=end

