import java.util.*;

public class IterativeDFS {
    List<Integer> adj[];
    int V;

    public IterativeDFS(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0;i < V;i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private void dfsUtil(int s, boolean visited[]) {
        Stack<Integer> st = new Stack<>();
        st.push(s);
        while(!st.isEmpty()) {
            int u = st.pop();
            if(!visited[u]) {
                System.out.print(u + " ");
                visited[u] = true;
            }
            for(int v : adj[u]) {
                if(!visited[v])
                    st.push(v);
            }
        }
    }

    private void dfs() {
        boolean visited[] = new boolean[V];
        for(int i = 0;i < V;i++) {
            if(!visited[i])
                dfsUtil(i, visited);
        }
    }

    public static void main(String[]args) throws Exception {
        IterativeDFS g = new IterativeDFS(5);
        g.addEdge(1, 0);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.dfs();
    }
}