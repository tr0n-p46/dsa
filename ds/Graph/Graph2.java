import java.util.*;

public class Graph {

    List<Integer> adj[];
    int V;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0;i < V;i++)
            adj[i] = new ArrayList<Integer>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void bfs(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            visited[u] = true;
            Iterator<Integer> it = adj[u].iterator();
            while(it.hasNext()) {
                int v = it.next();
                if(!visited[v])
                    queue.add(v);
            }
        }
    }

    public void dfs(int u) {
        boolean visited[] = new boolean[V];
        dfsUtil(u, visited);
    }

    public void dfsUtil(int u, boolean visited[]) {
        visited[u] = true;
        System.out.print(u + " ");
        Iterator<Integer> it = adj[u].iterator();
        while(it.hasNext()) {
            int v = it.next();
            if(!visited[v])
                dfsUtil(v, visited);
        }
    }



    public static void main(String[]args) throws Exception {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.bfs(2);
        System.out.println();
        g.dfs(2);
    }
}