package exam;
import java.util.*;

public class SimpleDFS {
    static int V = 5; // Number of vertices
    static ArrayList<Integer>[] graph = new ArrayList[V];
    static boolean[] visited = new boolean[V];

    public static void main(String[] args) {
        // Initialize the graph
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        // Add edges
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 4);

        System.out.println("DFS Traversal starting from node 0:");
        dfs(0);
    }
    // Function to add an edge (undirected)
    static void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u); // Remove this line for directed graph
    }
    // DFS function
    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}

