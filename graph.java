import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph {
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt) {
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge> [] graph = new ArrayList[5];
        createGraph(graph);
        neighbour(graph, 2);
        bfs(graph);
    }
    public static void createGraph(ArrayList<Edge> []graph){
        for(int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,5));

        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        graph[4].add(new Edge(4,2,2));
    }
   public static void neighbour( ArrayList<Edge>[] graph, int src){
        for(int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            System.out.println(e.dest);
        }
    }
    //BFS Algorithm
    static void bfs(ArrayList<Edge> [] arr) {
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[arr.length];
        q.add(0);

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!visited[curr]){
                visited[curr]=true;
                System.out.print(curr+" ");
                for (int i = 0; i < arr[curr].size(); i++) {
                    Edge e = arr[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
}

