/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    private int pi=0;
    public TreeNode createTree(int[] preorder,int[] inorder,int inS,int inE){
        if(inS > inE || pi>= preorder.length){
            return null;
        }
        int rI = search(inorder, inS, inE, preorder[pi]);
        if(rI == -1){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pi]);
        pi++;
        root.left = createTree(preorder, inorder, inS, rI-1);
        root.right = createTree(preorder, inorder, rI+1, inE);
        return root;
    }
    public int search(int[] arr,int s,int e,int val){
        int ind=-1;
        for(int i=s;i<=e;i++){
            if(arr[i] == val){
                ind = i;
                break;
            }
        }
        return ind;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0 || inorder.length ==0){
            return null;
        }
        return createTree(preorder, inorder, 0, inorder.length-1);
    }
}
// @lc code=end

