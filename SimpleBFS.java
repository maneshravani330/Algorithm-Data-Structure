package exam;
import java.util.*;

public class SimpleBFS {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++)
            graph[i] = new ArrayList<>();

        // Add edges
        graph[0].add(1); 
        graph[1].add(0);
        graph[0].add(2); 
        graph[2].add(0);
        graph[1].add(3);
        graph[3].add(1);
        graph[2].add(4); 
        graph[4].add(2);

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        // Start BFS from node 0
        visited[0] = true;
        q.add(0);

        System.out.print("BFS: ");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int nbr : graph[node]) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    q.add(nbr);
                }
            }
        }
    }
}
