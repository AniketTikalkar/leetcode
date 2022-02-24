import java.util.ArrayList;

/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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
    boolean identical = true;
    public void inorder(TreeNode p,TreeNode q){
        if((p ==null && q!= null) || (p != null && q == null)){
            identical = false;
            return;
        }
        if(p == null && q == null){
            return;
        }
        inorder(p.left, q.left);
        if(p.val != q.val){
            identical = false;
        }
        inorder(p.right,q.right);
    }
    public void postorder(TreeNode p,TreeNode q){
        if((p ==null && q!= null) || (p != null && q == null)){
            identical = false;
            return;
        }
        if(p == null && q == null){
            return;
        }
        postorder(p.left, q.left);
        postorder(p.right,q.right);
        if(p.val != q.val){
            identical = false;
        }
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        inorder(p, q);
        if(!identical){
            return false;
        }
        postorder(p, q);
        return identical;
    }
}
// @lc code=end

