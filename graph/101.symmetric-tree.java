/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isMirror(TreeNode a,TreeNode b){
        if(a == null && b==null){
            return true;
        }
        if((a==null && b!= null) || (a!=null && b == null)){
            return false;
        }
        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
}
// @lc code=end

