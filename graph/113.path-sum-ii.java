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
    
    public void check(TreeNode root,int t,List<Integer> arr,List<List<Integer>> list){
        if(root == null){
            return ;
        }
        arr.add(Integer.valueOf(root.val));
        if(isLeaf(root) && root.val == t){
            
            list.add(new LinkedList(arr));
            arr.remove(arr.size()-1);
            return ;
        }
        check(root.left, t-root.val, arr,list);
        check(root.right, t-root.val, arr,list);
       arr.remove(arr.size()-1);
    }
    public boolean isLeaf(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> arr = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        check(root, targetSum, arr,list);
        return list;
    }
}
// @lc code=end

