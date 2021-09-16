import java.util.*;

public class TransitiveClosure {
    List<Integer> adj[];
    int V;
    int tc[][];

    public TransitiveClosure(int V) {
        this.V = V;
        adj = new ArrayList[V];
        tc = new int[V][V];
        for(int i = 0;i < V;i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private void dfsUtil(int u, int v) {
       tc[u][v] = 1;
       for(int i : adj[v]) {
            if(tc[u][i] == 0)
                dfsUtil(u, i);
       }
    }

    private void transitiveClosure() {
        for(int i = 0;i < V;i++) {
            dfsUtil(i, i);
        }
        for(int i = 0;i < V;i++) {
            System.out.println(Arrays.toString(tc[i]));
        }
    }

    public static void main(String[]args) throws Exception {
        TransitiveClosure g = new TransitiveClosure(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.transitiveClosure();
    }
}