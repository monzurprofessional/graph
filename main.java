
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class main {
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,1));
        graph[1].add(new Edge(1,4,1));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,5,1));
        
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));

        graph[4].add(new Edge(4,1,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,2,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));




        System.err.println("BFS");
        bfs(graph,0);
        System.err.println("DFS");
        dfs(graph, 0);
    }
    static void bfs(ArrayList<Edge> []graph, int src){
        boolean [] visited = new boolean[graph.length];
       Queue <Integer> q = new LinkedList<>();
       q.add(src);
       while(!q.isEmpty()){
        int curr = q.remove();
        if(!visited[curr]){
            visited[curr]=true;
            System.err.println(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                int neighbours=e.dest;
                q.add(neighbours);
            }
        }
       }

    }
    static void dfs(ArrayList<Edge> [] graph, int src){
        Stack<Integer> s = new Stack<>();
        boolean [] vis = new boolean[graph.length];
        s.push(src);

        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                vis[curr]=true;
                System.err.println(curr);
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    int neighbours = e.dest;
                    s.push(neighbours);
                }
            }
        }
    }
}
                     