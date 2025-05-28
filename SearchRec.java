package data_structure4;

class SNode {
    private int data;
    private SNode left, right;

    public SNode(int data) {
        this.data = data;
    }

    public int getData() { 
    	return data; 
    	}
    public SNode getLeft() {
    	return left;
    	}
    public SNode getRight() {
    	return right; 
    	}
    public void setLeft(SNode left) { 
    	this.left = left; 
    	}
    public void setRight(SNode right) {
    	this.right = right; 
    	}
}

class BinarySearch1 {
    private SNode root;

    public SNode search(int d) {
        return search_rec(root, d);
    }

    private SNode search_rec(SNode r, int d) {
        if (r == null) {
            return null; 
        }
        if (d < r.getData()) {
            return search_rec(r.getLeft(), d); 
        } else if (d > r.getData()) {
            return search_rec(r.getRight(), d); 
        } else {
            return r; 
        }
    }

    public void insert(int d) {
        root = insert_rec(root, d);
    }

    private SNode insert_rec(SNode r, int d) {
        if (r == null) {
            SNode new_node = new SNode(d);
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

public class SearchRec {
    public static void main(String[] args) {
        BinarySearch1 tree = new BinarySearch1();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        SNode result = tree.search(10); 
        if (result != null) {
            System.out.println("Node found with data: " + result.getData());
        } else {
            System.out.println("Node not found.");
        }

        result = tree.search(20); 
        if (result != null) {
            System.out.println("Node found with data: " + result.getData());
        } else {
            System.out.println("Node not found.");
        }
    }
}
