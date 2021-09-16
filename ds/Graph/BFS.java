import java.util.*;

public class BFS {
    List<Integer> adj[];
    int V;

    public BFS(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0;i < V;i++)
            adj[i] = new ArrayList<Integer>();
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private void bfs(int s) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            Iterator<Integer> it = adj[u].iterator();
            while(it.hasNext()) {
                int v = it.next();
                if(!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[]args) throws Exception {
        BFS g = new BFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(1, 2);
        g.bfs(0);
    }
}