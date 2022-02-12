import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    //visited regions will be safe and should not be flipped
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m<3 ||n<3){
            return ;
        }
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        //find O from corners and that'll be your bfs start nodes
        for(int i=0;i<m;i++){
            
            if(board[i][0] == 'O'){
                int start[] = new int[2];
                start[0] = i;
                start[1] = 0;
                q.add(start);
                visited[i][0] = true;
            }
            if(board[i][n-1] == 'O'){
                int start[] = new int[2];
                start[0] = i;
                start[1] = n-1;
                q.add(start);
                visited[i][n-1] = true;
            }
            
        }
        for(int i=1;i<n-1;i++){
            
            if(board[0][i] == 'O'){
                int start[] = new int[2];
                start[0] = 0;
                start[1] = i;
                q.add(start);
                visited[0][i] = true;
            }
            if(board[m-1][i] == 'O'){
                int start[] = new int[2];
                start[0] = m-1;
                start[1] = i;
                q.add(start);
                visited[m-1][i] = true;
            }
            
        }
        //start search from all these nodes
        while(!q.isEmpty()){
            int curr[] = q.remove();
            for(int i=0;i<4;i++){
                int r = curr[0] + dir[i][0];
                int c = curr[1] + dir[i][1];
                if(r>=0 && c >=0 && r < m && c < n && board[r][c] == 'O' && !visited[r][c]){
                    int node[] = {r,c};
                    q.add(node);
                    visited[r][c] = true;
                }
            }
        }
        //all O nodes reachable from borders have been marked visited at this point
        //traverse board and if its a O that hasnt been visited then its part of a region unreachable from edge, so we have to flip its value to X
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}
// @lc code=end

