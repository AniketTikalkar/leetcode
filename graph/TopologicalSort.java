import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void dfs(int s,boolean[] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack){
        visited[s] = true;
        for(int neighbour : adj.get(s)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, adj, stack);
            }
        }
        stack.push(s);
    }
    public static void topoSort(int s,int v,ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i,visited,adj,stack);
            }
        }
        while(!stack.empty()){
            System.out.print(stack.pop() + "->");
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 1);
        graph.addEdge(4, 0);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        topoSort(5, 6, graph.adjList);
    }
}
