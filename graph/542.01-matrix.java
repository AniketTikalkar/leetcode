import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];
        int row[] = {-1,0,1,0};
        int col[] = {0,1,0,-1};
        //O(mn)
        //fill queue with all nodes that are 0 first, this will ensure that you reach a node from minimum distance first,
        //basically distance ordering will be maintained this way, think of it as starting BFS from multiple nodes simultaneously
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] ==0){
                    int start[] = {i,j};
                    q.add(start);
                    visited[i][j] =true;
                    ans[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int curr[] = q.remove();
            //visit neighbours
            for(int i=0;i<4;i++){
                int r = curr[0] + row[i];
                int c = curr[1] + col[i];
                //elements with 0 val would've already been visited
                if(r >=0 && r <m && c >=0 && c < n && !visited[r][c]){
                   int node[] = {r,c};
                   q.add(node);
                   visited[r][c] = true;
                   ans[r][c] = ans[curr[0]][curr[1]] + 1;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

