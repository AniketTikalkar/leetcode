import java.util.LinkedList;
import java.util.Queue;
/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public boolean inBounds(int r,int c,int rowLen,int colLen){
        return r>=0 && r< rowLen && c >=0 && c< colLen;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rowLen = image.length;
        int colLen = image[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int row[] = {-1,0,1,0};
        int col[] = {0,1,0,-1};
        Queue<Pair> q = new LinkedList<Pair>();
        Pair startNode = new Pair(sr,sc);
        q.add(startNode);
        while(q.size() != 0){
            Pair node = q.remove();
            int r = node.key;
            int c = node.val;
            int oldColor = image[r][c];
            visited[r][c] = true;
            image[r][c] = newColor;
            //iterate neighbours of this node
            for(int i=0;i<4;i++){
                if(inBounds(r+row[i], c + col[i], rowLen, colLen) && !visited[r+row[i]][c+col[i]] && image[r+row[i]][c+col[i]] == oldColor ){
                    Pair neighBourNode = new Pair(r+row[i],c+col[i]);
                    q.add(neighBourNode);
                }
            }

        }
        return image;
    }
    class Pair{
        int key;
        int val;
        Pair(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
}
// @lc code=end

