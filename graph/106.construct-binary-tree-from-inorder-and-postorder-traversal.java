/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    private int piOffestFromEnd = 1;
    public TreeNode createTree(int[] postorder,int[] inorder,int inS,int inE){
        int ind = postorder.length-piOffestFromEnd;
        if(inS > inE || ind<0){
            return null;
        }
        int rI = search(inorder, postorder[ind], inS, inE);
        if(rI == -1){
            return null;
        }
        piOffestFromEnd++;
        TreeNode root = new TreeNode(postorder[ind]);
        root.right = createTree(postorder, inorder, rI+1, inE);
        root.left = createTree(postorder, inorder, inS, rI-1);
        return root;

    }
    public int search(int[] arr,int val,int s,int e){
        int aI = -1;
        for(int i=s;i<=e;i++){
            if(arr[i] == val){
                aI = i;
                break;
            }
        }
        return aI;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length== 0 || postorder.length ==0 || inorder.length != postorder.length){
            return null;
        }
        return createTree(postorder, inorder, 0, inorder.length-1);
    }
}
// @lc code=end

