package exam;

import java.util.Scanner;

class SubNode {
    int data;
    SubNode left, right;

    SubNode(int data) {
        this.data = data;
    }
}

public class SubtreeCheck {

    // Insert node in BST
    SubNode insert(SubNode root, int data) {
        if (root == null) {
            return new SubNode(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Check if two trees are identical
    boolean isIdentical(SubNode a, SubNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.data == b.data && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

    // Check if one tree is a subtree of another
    boolean isSubtree(SubNode big, SubNode small) {
        if (big == null) {
            return false;
        }
        if (isIdentical(big, small)) {
            return true;
        }
        return isSubtree(big.left, small) || isSubtree(big.right, small);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SubtreeCheck obj = new SubtreeCheck();

        SubNode rootA = null, rootB = null;

        // Input for Tree A
        System.out.println("Enter values for Tree A (-1 to stop):");
        while (true) {
            int n = sc.nextInt();
            if (n == -1) break;
            rootA = obj.insert(rootA, n);
        }

        // Input for Tree B
        System.out.println("Enter values for Tree B (-1 to stop):");
        while (true) {
            int n = sc.nextInt();
            if (n == -1) break;
            rootB = obj.insert(rootB, n);
        }

        // Check if Tree A is a subtree of Tree B
        if (obj.isSubtree(rootB, rootA)) {
            System.out.println("Tree A is a subtree of Tree B.");
        } else {
            System.out.println("Tree A is NOT a subtree of Tree B.");
        }
    }
}
