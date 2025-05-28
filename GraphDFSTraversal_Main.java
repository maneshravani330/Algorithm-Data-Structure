package data_structure7;

import java.util.Scanner;

class IntStack {
    private int[] stack;
    private int top;

    public IntStack(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int item) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = item;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class MyGraphForDFS {
    private int[][] adj;
    private int[] state;
    private int n;

    public MyGraphForDFS(int n) {
        this.n = n;
        adj = new int[n][n];
        state = new int[n];
    }

    public void createGraph() {
        int maxEdges = n * (n - 1); // directed graph
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= maxEdges; i++) {
            System.out.print("Enter edge (-1 -1 to quit): ");
            int origin = sc.nextInt();
            int destin = sc.nextInt();
            if (origin == -1 && destin == -1)
                break;
            if (origin < 0 || origin >= n || destin < 0 || destin >= n) {
                System.out.println("Invalid edge!");
                i--;
            } else {
                adj[origin][destin] = 1;
            }
        }
        // sc.close(); // Don't close if you need it elsewhere
    }

    public void insertEdge(int origin, int destin) {
        if (origin < 0 || origin >= n || destin < 0 || destin >= n) {
            System.out.println("Invalid vertices");
            return;
        }
        adj[origin][destin] = 1;
    }

    public void deleteEdge(int origin, int destin) {
        if (origin < 0 || origin >= n || destin < 0 || destin >= n || adj[origin][destin] == 0) {
            System.out.println("This edge does not exist");
            return;
        }
        adj[origin][destin] = 0;
    }

    public void display() {
        System.out.print("    ");
        for (int i = 0; i < n; i++)
            System.out.print(i + "   ");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < n; j++)
                System.out.print(adj[i][j] + "   ");
            System.out.println();
        }
    }

    public void DF_Traversal(int v) {
        for (int i = 0; i < n; i++) {
            state[i] = 0; // reset state before every traversal
        }

        IntStack st = new IntStack(n);
        st.push(v);

        while (!st.isEmpty()) {
            v = st.pop();
            if (state[v] == 0) {
                System.out.print(v + " ");
                state[v] = 1;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (adj[v][i] == 1 && state[i] == 0) {
                    st.push(i);
                }
            }
        }
    }
}

public class GraphDFSTraversal_Main {
    public static void main(String[] args) {
        MyGraphForDFS g = new MyGraphForDFS(12);

        // Create graph manually
        g.insertEdge(0, 1);
        g.insertEdge(0, 3);
        g.insertEdge(1, 2);
        g.insertEdge(1, 5);
        g.insertEdge(1, 4);
        g.insertEdge(2, 3);
        g.insertEdge(2, 5);
        g.insertEdge(3, 6);
        g.insertEdge(4, 7);
        g.insertEdge(5, 7);
        g.insertEdge(5, 6);
        g.insertEdge(5, 8);
        g.insertEdge(6, 9);
        g.insertEdge(8, 9);
        g.insertEdge(7, 8);

        System.out.println("DFS Traversal starting from vertex 0:");
        g.DF_Traversal(0);

        System.out.println("\n\nAdjacency Matrix of Graph:");
        g.display();
    }
}
