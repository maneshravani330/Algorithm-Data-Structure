package data_structure3;

import java.util.LinkedList;
import java.util.Queue;

// Node class
class BTNode {
    private int data;
    private BTNode left, right;

    public BTNode(int d) {
        data = d;
        left = right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int d) {
        data = d;
    }

    public void setLeft(BTNode l) {
        left = l;
    }

    public void setRight(BTNode r) {
        right = r;
    }

    public BTNode getLeft() {
        return left;
    }

    public BTNode getRight() {
        return right;
    }
}

// Binary Tree class
class BinaryTree {
    private BTNode root;

    public void setRoot(BTNode r) {
        root = r;
    }

    public BTNode getRoot() {
        return root;
    }

    public BTNode createNode(int d) {
        return new BTNode(d);
    }

    public void preOrder() {
        visitPreOrder(root);
    }

    private void visitPreOrder(BTNode root) {
        if (root == null) return;

        System.out.print(root.getData() + " ");
        visitPreOrder(root.getLeft());
        visitPreOrder(root.getRight());
    }

    public void insertLevelwise(int d) {
        BTNode new_node = new BTNode(d);
        if (root == null) {
            root = new_node;
            return;
        }

        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BTNode iter = q.remove();

            if (iter.getLeft() == null) {
                iter.setLeft(new_node);
                return;
            } else {
                q.add(iter.getLeft());
            }

            if (iter.getRight() == null) {
                iter.setRight(new_node);
                return;
            } else {
                q.add(iter.getRight());
            }
        }
    }

    // Level order traversal
    public void levelOrderTraversal() {
        if (root == null) return;

        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BTNode iter = q.remove();
            System.out.print(iter.getData() + " ");

            if (iter.getLeft() != null)
                q.add(iter.getLeft());

            if (iter.getRight() != null)
                q.add(iter.getRight());
        }
    }
}

// Main class
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.setRoot(bt.createNode(10));
        bt.getRoot().setLeft(bt.createNode(20));
        bt.getRoot().setRight(bt.createNode(30));
        bt.getRoot().getLeft().setLeft(bt.createNode(40));
        bt.getRoot().getLeft().setRight(bt.createNode(50));

        System.out.println("Preorder Traversal:");
        bt.preOrder();

        System.out.println("\nLevel Order Traversal:");
        bt.levelOrderTraversal();
    }
}
