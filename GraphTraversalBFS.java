package data_structure7;

import java.util.Scanner;

class intQueue {
    private int[] queue;
    private int front, rear;

    public intQueue(int size) {
        queue = new int[size];
        front = rear = -1;
    }

    public void insert(int item) {
        if (rear == queue.length - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        if (front == -1) front = 0;
        queue[++rear] = item;
    }

    public int del() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return queue[front++];
    }

    public boolean isEmpty() {
        return front == -1 || front > rear;
    }
}

class myGraphforBFS {
    int[][] adj;
    int n;

    public myGraphforBFS(int i) {
        n = i;
        adj = new int[n][n];
    }

    public void create_graph() {
        int max_edges = n * (n - 1);
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= max_edges; i++) {
            System.out.println("Enter edge (-1 -1 to quit): ");
            int origin = sc.nextInt();
            int destin = sc.nextInt();
            if (origin == -1 && destin == -1)
                break;
            if (origin >= n || destin >= n || origin < 0 || destin < 0) {
                System.out.println("Invalid edge!");
                i--;
            } else
                adj[origin][destin] = 1;
        }
    }

    public void insert_edge(int origin, int destin) {
        if (origin < 0 || origin >= n || destin < 0 || destin >= n) {
            System.out.println("Invalid vertices");
            return;
        }
        adj[origin][destin] = 1;
    }

    public void del_edge(int origin, int destin) {
        if (origin < 0 || origin >= n || destin < 0 || destin >= n || adj[origin][destin] == 0) {
            System.out.println("This edge does not exist");
            return;
        }
        adj[origin][destin] = 0;
    }

    public void display() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(" " + adj[i][j]);
            System.out.println();
        }
    }

    public void BF_Traversal(int v) {
        int[] state = new int[n]; // 1=initial, 2=waiting, 3=visited
        for (int i = 0; i < n; i++)
            state[i] = 1;

        intQueue q = new intQueue(n);
        q.insert(v);
        state[v] = 2;

        System.out.print("BFS Traversal: ");
        while (!q.isEmpty()) {
            v = q.del();
            System.out.print(v + " ");
            state[v] = 3;
            for (int i = 0; i < n; i++) {
                if (adj[v][i] == 1 && state[i] == 1) {
                    q.insert(i);
                    state[i] = 2;
                }
            }
        }
        System.out.println();
    }
}

public class GraphTraversalBFS {
    public static void main(String[] args) {
        myGraphforBFS g = new myGraphforBFS(9);
        g.create_graph();       // Create your graph by entering edges
        g.display();            // Optional: display adjacency matrix
        g.BF_Traversal(1);      // Start BFS from vertex 1
    }
}
