import java.util.ArrayList;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    int WHITE = 0, GRAY = 1, BLACK = 2;

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] color, int s) {
        // we are processing this vertexx
        color[s] = GRAY;
        for (int neighbour : adj.get(s)) {
            // if you see neighbour in processing, this means you found a backEdge so a
            // cycle detected
            if (color[neighbour] == GRAY) {
                return true;
            }
            if (color[neighbour] == WHITE && dfs(adj, color, neighbour)) {
                return true;
            }
        }
        // you finished processing now, so color it black
        color[s] = BLACK;
        return false;
    }

    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean hasCycle = false;
        // default value will be 0 so white
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            //if one cycle detected then break loop
            if(hasCycle){
                break;
            }
            else if (color[i] == WHITE) {
                hasCycle = dfs(adj, color, i);
            }
        }
        return hasCycle;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        boolean canfinish = false;
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // you basically have to check for cycle in this directed graph adj
        canfinish = !isCyclic(adj, numCourses);
        return canfinish;
    }
}
// @lc code=end
