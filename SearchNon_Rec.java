package data_structure4;

class SNRNode {
    private int data;
    private SNRNode left, right;

    public SNRNode(int data) {
        this.data = data;
    }

    public int getData() { 
    	return data; 
    	}
    public SNRNode getLeft() { 
    	return left; 
    	}
    public SNRNode getRight() { 
    	return right; 
    	}
    public void setLeft(SNRNode left) { 
    	this.left = left; 
    	}
    public void setRight(SNRNode right) {
    	this.right = right; 
    	}
}

class BinarySearch2 {
    private SNRNode root;

    public void insert(int d) {
        root = insertRec(root, d);
    }

    private SNRNode insertRec(SNRNode r, int d) {
        if (r == null) return new SNRNode(d);
        if (d < r.getData()) r.setLeft(insertRec(r.getLeft(), d));
        else if (d > r.getData()) r.setRight(insertRec(r.getRight(), d));
        else System.out.println("Duplicate value...");
        return r;
    }

    public SNRNode search(int d) {
        SNRNode current = root;
        while (current != null) {
            if (d < current.getData()) 
            	current = current.getLeft();
            else if (d > current.getData())
            	current = current.getRight();
            else return current; 
        }
        return null; 
    }
}
public class SearchNon_Rec {
    public static void main(String[] args) {
        BinarySearch2 tree = new BinarySearch2();
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(10);
        tree.insert(30);

        int key1 = 30;
        int key2 = 90;

        SNRNode result1 = tree.search(key1);
        if (result1 != null) {
            System.out.println("Node found with data: " + result1.getData());
        } else {
            System.out.println("Node with data " + key1 + " not found.");
        }

        SNRNode result2 = tree.search(key2);
        if (result2 != null) {
            System.out.println("Node found with data: " + result2.getData());
        } else {
            System.out.println("Node with data " + key2 + " not found.");
        }
    }
}
