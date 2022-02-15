import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public void travel(TreeStructNode root,ArrayList<Integer> in){
        if(root == null){
            return;
        }
        if(root.left != null){
            travel(root.left, in);
        }
        in.add(root.val);
        if(root.right != null){
            travel(root.right, in);
        }
    }
    public List<Integer> inorderTraversal(TreeStructNode root) {
        ArrayList<Integer> in = new ArrayList<>();
        travel(root, in);
        return in;
    }
}
// @lc code=end

