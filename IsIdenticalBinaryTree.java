package data_structure4;

import java.util.LinkedList;
import java.util.Queue;

class IDNode {
    private int data;
    private IDNode left, right;

    public IDNode(int data) {
        this.data = data;
    }

    public int getData() { 
    	return data; 
    	}
    public IDNode getLeft() {
    	return left; 
    	}
    public IDNode getRight() {
    	return right; 
    	}
    public void setLeft(IDNode left) {
    	this.left = left; 
    	}
    public void setRight(IDNode right) { 
    	this.right = right; 
    	}
}

class BinaryTree {
    private IDNode root;

    public IDNode getRoot() { 
    	return root;
    	}
    public void setRoot(IDNode root) {
    	this.root = root; 
    	}
}

public class IsIdenticalBinaryTree {

    public static boolean isIdentical(BinaryTree bt1, BinaryTree bt2) {
        if (bt1.getRoot() == null && bt2.getRoot() == null)
            return true;

        if (bt1.getRoot() == null || bt2.getRoot() == null)
            return false;

        Queue<IDNode> q1 = new LinkedList<>();
        Queue<IDNode> q2 = new LinkedList<>();

        q1.add(bt1.getRoot());
        q2.add(bt2.getRoot());

        while (!q1.isEmpty() && !q2.isEmpty()) {
            IDNode iter1 = q1.remove();
            IDNode iter2 = q2.remove();

            if (iter1.getData() != iter2.getData())
                return false;

            if ((iter1.getLeft() != null && iter2.getLeft() == null) ||
                (iter1.getLeft() == null && iter2.getLeft() != null))
                return false;

            if ((iter1.getRight() != null && iter2.getRight() == null) ||
                (iter1.getRight() == null && iter2.getRight() != null))
                return false;

            if (iter1.getLeft() != null) q1.add(iter1.getLeft());
            if (iter1.getRight() != null) q1.add(iter1.getRight());

            if (iter2.getLeft() != null) q2.add(iter2.getLeft());
            if (iter2.getRight() != null) q2.add(iter2.getRight());
        }

        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        // Tree 1
        IDNode root1 = new IDNode(1);
        root1.setLeft(new IDNode(2));
        root1.setRight(new IDNode(3));
        BinaryTree bt1 = new BinaryTree();
        bt1.setRoot(root1);

        // Tree 2
        IDNode root2 = new IDNode(1);
        root2.setLeft(new IDNode(2));
        root2.setRight(new IDNode(3));
        BinaryTree bt2 = new BinaryTree();
        bt2.setRoot(root2);

        // Check if trees are identical
        boolean result = isIdentical(bt1, bt2);
        System.out.println("Are the two binary trees identical:" + result);
    }
}
