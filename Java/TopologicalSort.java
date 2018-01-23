import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    private Graph(int v) {
        this.V = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            this.adj[i] = new LinkedList<>();
    }

    private void addEdge(int u, int v) {
        this.adj[u].add(v);
    }

    public void topologicalSort() {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[this.V];
        for (int i = 0; i < this.V; i++) {
            if (!visited[i])
                helper(i, st, visited);
        }
        while (!st.isEmpty())
            System.out.print(st.pop() + " ");
        System.out.println(" <- Topological Sort");
    }

    private void helper(int n, Stack<Integer> st, boolean[] visited) {
        visited[n] = true;
        for (int i : this.adj[n])
            if (!visited[i])
                helper(i, st, visited);
        st.push(n);
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.topologicalSort();
    }
}
