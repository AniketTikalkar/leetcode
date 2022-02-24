/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode createTree(int[] arr,int s, int e){
        if(s > e){
            return null;
        }
        int m = (s+e)/2;
        TreeNode root = new TreeNode(arr[m]);
        root.left = createTree(arr, s, m-1);
        root.right = createTree(arr, m+1, e);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length-1);   
    }
}
// @lc code=end

