import java.util.*;

public class SCC {
    int V;
    List<Integer> adj[];
    List<Integer> adjT[];
    Stack<Integer> s;

    public SCC(int V) {
        this.V = V;
        adj = new ArrayList[V];
        adjT = new ArrayList[V];
        for(int i = 0;i < V;i++) {
            adj[i] = new ArrayList();
            adjT[i] = new ArrayList();
        }
        s = new Stack<>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adjT[v].add(u);
    }

    public void dfs(List<Integer> adj[]) {
        boolean visited[] = new boolean[V];
        for(int i = 0;i < V;i++) {
            if(!visited[i])
                dfsUtil(adj, i, visited, true);
        }
    }

    public void dfsUtil(List<Integer> adj[], int u, boolean visited[], boolean flag) {
        visited[u] = true;
        Iterator<Integer> it = adj[u].iterator();
        while(it.hasNext()) {
            int v = it.next();
            if(!visited[v])
                dfsUtil(adj, v, visited, flag);
        }
        if(flag)
            s.push(u);
    }

    public void compute() {
        dfs(adj);
        boolean visited[] = new boolean[V];
        while(!s.isEmpty()) {
            int u = s.pop();
            System.out.print(u + " ");
            if(!visited[u])
                dfsUtil(adjT, u, visited, false);
        }
    }

    public static void main(String[]args) throws Exception {
        SCC scc = new SCC(5);
        scc.addEdge(1, 0);
        scc.addEdge(0, 2);
        scc.addEdge(2, 1);
        scc.addEdge(0, 3);
        scc.addEdge(3, 4);
        scc.compute();
    }
}