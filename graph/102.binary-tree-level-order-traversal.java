import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> a = new LinkedList<>();
        if(root ==null){
            return a;
        }
        Queue<Object[]> q = new LinkedList<>();
        Object o[] = new Object[2];
        o[0] = 0;
        o[1] = root;
        q.add(o);
        while(!q.isEmpty()){
            Object curr[] = q.remove();
            int currlevel = (Integer)curr[0];
            TreeNode currNode = (TreeNode)curr[1];
            if(a.size() < currlevel+1){
                a.add(new ArrayList<>());
                a.get(currlevel).add(currNode.val);
            }
            else{
                a.get(currlevel).add(currNode.val);
            }
            if(currNode.left != null){
                Object node[] = new Object[2];
                node[0] = currlevel +1;
                node[1] = currNode.left;
                q.add(node);
            }
            if(currNode.right != null){
                Object node[] = new Object[2];
                node[0] = currlevel +1;
                node[1] = currNode.right;
                q.add(node);
            }
        }
        return a;
    }
}
// @lc code=end

