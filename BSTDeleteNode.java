package data_structure4;

import java.util.Scanner;

class DNode {
    private int data;
    private DNode left, right;

    public DNode(int data) {
        this.data = data;
    }

    public int getData() { 
    	return data; 
    	}
    public DNode getLeft() {
    	return left; 
    	}
    public DNode getRight() {
    	return right;
    	}
    public void setLeft(DNode left) {
    	this.left = left; 
    	}
    public void setRight(DNode right) {
    	this.right = right; 
    	}
}

class BST1 {
    private DNode root;

    public void insert(int d) {
        root = insertRec(root, d);
    }

    private DNode insertRec(DNode r, int d) {
        if (r == null) return new DNode(d);

        if (d < r.getData()) r.setLeft(insertRec(r.getLeft(), d));
        else if (d > r.getData()) r.setRight(insertRec(r.getRight(), d));
        else System.out.println("Duplicate Value...");
        return r;
    }

    public void del(int d) {
        root = delRec(root, d);
    }

    private DNode delRec(DNode r, int d) {
        if (r == null) {
            System.out.println("Element not found...");
            return null;
        }

        if (d < r.getData()) {
            r.setLeft(delRec(r.getLeft(), d));
        } else if (d > r.getData()) {
            r.setRight(delRec(r.getRight(), d));
        } else {
            if (r.getLeft() != null && r.getRight() != null) {
                DNode succ = r.getRight();
                while (succ.getLeft() != null) {
                    succ = succ.getLeft();
                }
                r = new DNode(succ.getData());
                r.setLeft(delRec(r.getLeft(), succ.getData()));
            } else if (r.getLeft() != null) {
                r = r.getLeft();
            } else if (r.getRight() != null) {
                r = r.getRight();
            } else {
                r = null;
            }
        }
        return r;
    }

    public void inorder(DNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    public void display() {
        inorder(root);
        System.out.println();
    }

    public DNode getRoot() {
        return root;
    }
}

public class BSTDeleteNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST1 tree = new BST1();

        System.out.print("Enter number of nodes to insert: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " node values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            tree.insert(val);
        }

        System.out.println("BST (Inorder Traversal):");
        tree.display();

        System.out.print("Enter node value to delete: ");
        int delVal = sc.nextInt();
        tree.del(delVal);

        System.out.println("After deletion (Inorder Traversal):");
        tree.display();
    }
}
