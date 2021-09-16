public class Graph {
    List<Integer> adj[];
    int V;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0;i < V;i++)
            adj[i] = new ArrayList<Integer>();
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public static void main(String[]args) throws Exception {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
    }
}