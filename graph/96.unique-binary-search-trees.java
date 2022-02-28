/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int arr[] = new int[n+1];
        arr[0] =1;
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                arr[i] += (arr[j-1]*arr[i-j]);
            }
        }
        return arr[n];
    }
}
// @lc code=end
