package data_structure4;

class RNode {
    private int data;
    private RNode left, right;

    public RNode(int data) {
        this.data = data;
    }

    public int getData() { 
    	return data;
    	}
    public RNode getLeft() {
    	return left; 
    	}
    public RNode getRight() { 
    	return right;
    	}
    public void setLeft(RNode left) {
    	this.left = left; 
    	}
    public void setRight(RNode right) {
    	this.right = right;
    	}
}

class BinarySearch {
    private RNode root;

    public void insert(int d) {
        root = insert_rec(root, d);
    }

    private RNode insert_rec(RNode r, int d) {
        if (r == null) {
            RNode new_node = new RNode(d);
            return new_node;
        }

        if (d < r.getData()) {
            r.setLeft(insert_rec(r.getLeft(), d));
        } else if (d > r.getData()) {
            r.setRight(insert_rec(r.getRight(), d));
        } else {
            System.out.println("Duplicate value...");
        }

        return r;
    }
}

public class BSTinsertRec {
    public static void main(String[] args) {
        BinarySearch tree = new BinarySearch();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(5);
    }
}
