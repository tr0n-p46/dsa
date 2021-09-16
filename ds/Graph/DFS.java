import java.util.*;

public class DFS {

    List<Integer> adj[];
    int V;

    public DFS(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0;i < V;i++)
            adj[i] = new ArrayList<>();
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private void dfsUtil(int s, boolean visited[]) {
        visited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> it = adj[s].iterator();
        while(it.hasNext()) {
            int u = it.next();
            if(!visited[u])
                dfsUtil(u, visited);
        }
    }

    private void dfs() {
        boolean visited[] = new boolean[V];
        for(int i = 0;i < V;i++) {
            if(!visited[i]) {
                dfsUtil(i, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[]args) throws Exception {
        DFS g = new DFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.dfs();
    }
}