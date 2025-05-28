package exam;

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class TreeMirrorDemo {
    Node root;

    // Insert node in BST
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Inorder traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Sum of all nodes
    int sum(Node root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    // Create mirror of a tree
    Node mirror(Node root) {
        if (root == null) return null;
        Node mirrored = new Node(root.data);
        mirrored.left = mirror(root.right);
        mirrored.right = mirror(root.left);
        return mirrored;
    }

    // Check if two trees are mirror images
    boolean isMirror(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.data == b.data && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    // Search element in the tree
    boolean search(Node root, int key) {
        while (root != null) {
            if (key == root.data) {
                return true;
            } else if (key < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMirrorDemo tree = new TreeMirrorDemo();

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter the nodes:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            tree.root = tree.insert(tree.root, data);
        }

        System.out.println("Inorder traversal of original tree:");
        tree.inorder(tree.root);
        System.out.println();

        Node mirrorRoot = tree.mirror(tree.root);
        System.out.println("Inorder traversal of mirror tree:");
        tree.inorder(mirrorRoot);
        System.out.println();

        System.out.println("Sum of nodes: " + tree.sum(tree.root));

        System.out.print("Enter value to search: ");
        int key = sc.nextInt();
        boolean found = tree.search(tree.root, key);
        if (found) {
            System.out.println("Is " + key + " present? Yes");
        } else {
            System.out.println("Is " + key + " present? No");
        }

        boolean areMirrors = tree.isMirror(tree.root, mirrorRoot);
        if (areMirrors) {
            System.out.println("Are the trees mirror images? Yes");
        } else {
            System.out.println("Are the trees mirror images? No");
        }

    }
}

