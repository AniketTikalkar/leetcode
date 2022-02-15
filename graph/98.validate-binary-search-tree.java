import java.util.HashMap;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    
    public Integer getMax(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Integer maxval;
        if (root.left == null && root.right == null) {
            maxval = root.val;
            map.put(root.val, root.val);
        }
        maxval = Math.max(root.val, Math.max(getMax(root.left, map), getMax(root.right, map)));
        map.put(root.val, maxval);
        return maxval;
    }

    public Integer getMin(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        Integer minval;
        if (root.left == null && root.right == null) {
            minval = root.val;
            map.put(root.val, root.val);
        }
        minval = Math.min(root.val, Math.min(getMin(root.left, map), getMin(root.right, map)));
        map.put(root.val, minval);
        return minval;
    }

    public boolean valid(TreeNode root, HashMap<Integer, Integer> maxMap, HashMap<Integer, Integer> minMap) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean lvalid = false,rvalid = false;
        if (valid(root.left, maxMap, minMap) && valid(root.right, maxMap, minMap)) {
            lvalid = true;
            rvalid = true;
            if (root.left != null && root.val > maxMap.get(root.left.val)) {
                lvalid = true;
            } 
            else if(root.left != null && root.val <= maxMap.get(root.left.val)){
                lvalid = false;
            }
            if (root.right != null && root.val < minMap.get(root.right.val)) {
                rvalid =  true;
            }
            else if(root.right != null && root.val >= minMap.get(root.right.val)){
                rvalid = false;
            }
        }
        return lvalid && rvalid;
    }

    public boolean isValidBST(TreeNode root) {
        HashMap<Integer, Integer> maxMap = new HashMap<>();
        HashMap<Integer, Integer> minMap = new HashMap<>();
        
        getMax(root, maxMap);
        getMin(root, minMap);
        
    
        return valid(root, maxMap, minMap);
    }
}
// @lc code=end
