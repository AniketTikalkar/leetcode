import java.util.Stack;
import java.util.logging.Level;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Stack<TreeNode> stackLR = new Stack<>();
        Stack<TreeNode> stackRL = new Stack<>();
        List<List<Integer>> traversal = new LinkedList<>();
        if(root == null){
            return traversal;
        }
        stackLR.push(root);
        while(!stackLR.empty() || !stackRL.empty()){
            ArrayList<Integer> level = new ArrayList<>();
            while(!stackLR.empty()){
                TreeNode currNode = stackLR.pop();
                level.add(currNode.val);
                if(currNode.left != null){
                    stackRL.push(currNode.left);
                }
                if(currNode.right != null){
                    stackRL.push(currNode.right);
                }
                
            }
            if(!level.isEmpty()){
                traversal.add(level);
                continue;
            }
            while(!stackRL.empty()){
                TreeNode currNode = stackRL.pop();
                level.add(currNode.val);
                if(currNode.right != null){
                    stackLR.push(currNode.right);
                }
                if(currNode.left != null){
                    stackLR.push(currNode.left);
                }
                
            }
            traversal.add(level);
           
        }
        return traversal;
    }
}
// @lc code=end

