import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    public boolean inBounds(int r, int c, int rl, int cl) {
        return r >= 0 && r < rl && c >= 0 && c < cl;
    }

    public Pair startNode(int[][] grid) {
        Pair p = null;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    p = new Pair(i, j);
                    return p;
                }
            }
        }
        return p;
    }

    public int islandPerimeter(int[][] grid) {
        int p = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean visited[][] = new boolean[rowLen][colLen];
        int row[] = { -1, 0, 1, 0 };
        int col[] = { 0, 1, 0, -1 };
        Pair start = startNode(grid);
        if (start == null) {
            return p;
        }
        q.add(start);
        visited[start.k][start.v] = true;
        while (q.size() != 0) {
            Pair node = q.remove();
            int r = node.k;
            int c = node.v;

            int nbrCnt = 0;
            for (int i = 0; i < 4; i++) {
                if (inBounds(r + row[i], c + col[i], rowLen, colLen) && grid[r + row[i]][c + col[i]] == 1) {

                    nbrCnt++;
                    if (!visited[r + row[i]][c + col[i]]) {
                        Pair nbr = new Pair(r + row[i], c + col[i]);
                        q.add(nbr);
                        visited[r + row[i]][c + col[i]] = true;
                    }

                }
            }
            p += (4 - nbrCnt);
        }
        return p;
    }

    class Pair {
        int k;
        int v;

        Pair(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
}
// @lc code=end
