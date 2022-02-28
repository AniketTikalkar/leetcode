import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    List<List<Integer>> list = new LinkedList<>();
    public boolean check(TreeNode root,int t,ArrayList<Integer> arr){
        if(root == null){
            return false;
        }
        arr.add(root.val);
        if(isLeaf(root) && root.val == t){
            list.add(arr);
            return true;
        }
        boolean lt = check(root.left, t-root.val, arr);
        arr.clear();
        arr.add(root.val);
        boolean rt = check(root.right, t-root.val, arr);
        if(rt || lt){
            
            return true;
        }
        return false;
    }
    public boolean isLeaf(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> arr = new ArrayList<>();
        check(root, targetSum, arr);
        return list;
    }
}
// @lc code=end

