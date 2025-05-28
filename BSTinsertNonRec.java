package data_structure4;

class TreeNode {
    private int data;
    private TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
    	return data; 
    	}
    public TreeNode getLeft() {
    	return left; 
    	}
    public TreeNode getRight() { 
    	return right; 
    	}
    public void setLeft(TreeNode left) { 
    	this.left = left;
    	}
    public void setRight(TreeNode right) { 
    	this.right = right; 
    	}
}

class BST {
    private TreeNode root;

    public void setRoot(TreeNode r) {
        root = r;
    }

    public TreeNode getRoot() {
        return root;
    }

    // Insert without recursion
    public void insert_nonrec(int d) {
        TreeNode new_node = new TreeNode(d);
        if (root == null) {
            root = new_node;
            return;
        }

        TreeNode iter = root;
        while (true) {
            if (d < iter.getData()) {
                if (iter.getLeft() == null) {
                    iter.setLeft(new_node);
                    return;
                } else {
                    iter = iter.getLeft();
                }
            } else if (d > iter.getData()) {
                if (iter.getRight() == null) {
                    iter.setRight(new_node);
                    return;
                } else {
                    iter = iter.getRight();
                }
            } else {
                System.out.println("Duplicate Value...");
                return;
            }
        }
    }
}

public class BSTinsertNonRec {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert_nonrec(10);
        tree.insert_nonrec(5);
        tree.insert_nonrec(15);
        tree.insert_nonrec(5); // Will print Duplicate Value
    }
}
