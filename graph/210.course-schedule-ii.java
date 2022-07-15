import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    int WHITE = 0, GRAY = 1, BLACK = 2;

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] color, int s,Stack<Integer> stack) {
        // we are processing this vertexx
        color[s] = GRAY;
        for (int neighbour : adj.get(s)) {
            // if you see neighbour in processing, this means you found a backEdge so a
            // cycle detected
            if (color[neighbour] == GRAY) {
                return true;
            }
            if (color[neighbour] == WHITE && dfs(adj, color, neighbour,stack)) {
                return true;
            }
        }
        // you finished processing now, so color it black
        color[s] = BLACK;
        stack.push(s);
        return false;
    }

    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int n,Stack<Integer> stack) {
        boolean hasCycle = false;
        // default value will be 0 so white
        int color[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            // if one cycle detected then break loop
            if (hasCycle) {
                break;
            } else if (color[i] == WHITE) {
                hasCycle = dfs(adj, color, i,stack);
            }
            
        }
        return hasCycle;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int path[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // you basically have to check for cycle in this directed graph adj
        Stack<Integer> stack = new Stack<>();
        if(isCyclic(adj, numCourses,stack)){
            return new int[0];
        }
        int i=0;
        while(!stack.empty()){
            path[i] = stack.pop();
            i++;
        }
        return path;
    }
}
// @lc code=end

