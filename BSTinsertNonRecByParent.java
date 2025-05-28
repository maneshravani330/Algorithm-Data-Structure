package data_structure4;

class TreeNode1 {
    private int data;
    private TreeNode1 left, right;

    public TreeNode1(int data) {
        this.data = data;
    }

    public int getData() {
    	return data; 
    	}
    public TreeNode1 getLeft() {
    	return left;
    	}
    public TreeNode1 getRight() { 
    	return right;
    	}
    public void setLeft(TreeNode1 left) {
    	this.left = left;
    	}
    public void setRight(TreeNode1 right) { 
    	this.right = right; 
    	}
}

class BinarySearchTree {
    private TreeNode1 root;

    public void setRoot(TreeNode1 r) {
        root = r;
    }

    public TreeNode1 getRoot() {
        return root;
    }

    public void insert_nonrec_with_parent(int d) {
        TreeNode1 new_node = new TreeNode1(d);
        if (root == null) {
            root = new_node;
            return;
        }

        TreeNode1 iter = root;
        TreeNode1 par = null;

        while (iter != null) {
            par = iter;
            if (d < iter.getData())
                iter = iter.getLeft();
            else if (d > iter.getData())
                iter = iter.getRight();
            else {
                System.out.println("Duplicate value...");
                return;
            }
        }

        if (d < par.getData())
            par.setLeft(new_node);
        else
            par.setRight(new_node);
    }
}

public class BSTinsertNonRecByParent {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert_nonrec_with_parent(10);
        tree.insert_nonrec_with_parent(5);
        tree.insert_nonrec_with_parent(15);
        tree.insert_nonrec_with_parent(5); 
    }
}
