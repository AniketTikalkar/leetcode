import java.util.ArrayList;


public class Graph {
    int v;
    ArrayList<ArrayList<Integer>> adjList;

    Graph(int v){
        this.v = v;
        adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<Integer>());
        }
        
    }
    public void addEdge(int v,int w){
        adjList.get(v).add(w);
    }


}
