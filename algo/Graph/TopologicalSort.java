import java.util.*;

public class TopologicalSort {
    List<Integer> adj[];
    int V;

    public TopologicalSort(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0;i < V;i++)
            adj[i] = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void dfsUtil(int u, boolean visited[], Stack s) {
        visited[u] = true;
        Iterator<Integer> it = adj[u].iterator();
        while(it.hasNext()) {
            int v = it.next();
            if(!visited[v])
                dfsUtil(v, visited, s);
        }
        s.push(u);
    }

    public void sort() {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V];

        for(int i = 0;i < V;i++) {
            if(!visited[i])
                dfsUtil(i, visited, s);
        }
        while(!s.isEmpty()) {
            int v = s.pop();
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void main(String[]args) throws Exception {
        TopologicalSort sort = new TopologicalSort(6);
        sort.addEdge(2, 3);
        sort.addEdge(3, 1);
        sort.addEdge(4, 0);
        sort.addEdge(4, 1);
        sort.addEdge(5, 2);
        sort.addEdge(5, 0);
        sort.sort();
    }
}