import java.util.LinkedList;
import java.util.Scanner;

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

    private void bfs(int s) {
        boolean[] visited = new boolean[this.V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");
            for (int i : this.adj[s])
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
        }
    }

    private void dfs(int s) {
        boolean[] visited = new boolean[this.V];
        dfsTill(s, visited);
    }

    private void dfsTill(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int i : this.adj[s])
            if (!visited[i])
                dfsTill(i, visited);
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter starting point: ");
        int start = sc.nextInt();
        sc.close();
        System.out.println("BFS traversal of graph:");
        g.bfs(start);
        System.out.println();
        System.out.println("DFS traversal of graph:");
        g.dfs(start);
    }
}