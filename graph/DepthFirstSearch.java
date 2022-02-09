import java.util.ArrayList;

public class DepthFirstSearch {
    public static void performSearch(int s,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[s] = true;
        System.out.print(s + "->");
        for(int neighbour:adj.get(s)){
            if(!visited[neighbour]){
                performSearch(neighbour, adj, visited);
            }
        }
    }
    public static void dfs(int start,int v,ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[v];
        performSearch(start, adj, visited);
        for(int i=0;i<v;i++){
            if(!visited[i]){
                performSearch(i, adj, visited);
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);
        dfs(2, 8, graph.adjList);
    }
}
