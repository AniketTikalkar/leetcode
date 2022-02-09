import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void searchBFS(int s,int v,ArrayList<ArrayList<Integer>> adjList){
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(q.size() != 0){
            int curr = q.remove();
            System.out.print(curr + "->");
            for(Integer neighbourNode : adjList.get(curr)){
                if(!visited[neighbourNode]){
                    visited[neighbourNode] = true;
                    q.add(neighbourNode);
                }
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
        searchBFS(0, 8, graph.adjList);
    }
}
