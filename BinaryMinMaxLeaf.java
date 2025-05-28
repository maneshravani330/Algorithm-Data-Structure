package exam;

//BinaryNode class for Binary Tree
class BinaryNode {
    int data;
    BinaryNode left, right;

    public BinaryNode(int data) {
        this.data = data;
        left = right = null;
    }
}

//Binary Tree class
class Tree {
    BinaryNode root;

    // Insert new node into the tree
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private BinaryNode insertRec(BinaryNode root, int data) {
        if (root == null) {
            root = new BinaryNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Preorder traversal
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(BinaryNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Sum of non-leaf nodes
    public int sumOfNonLeafNodes() {
        return sumOfNonLeafRec(root);
    }

    private int sumOfNonLeafRec(BinaryNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0; // Skip leaf nodes
        }
        return node.data + sumOfNonLeafRec(node.left) + sumOfNonLeafRec(node.right);
    }

    // Maximum value
    public int findMaxValue() {
        return findMaxRec(root);
    }

    private int findMaxRec(BinaryNode node) {
        if (node == null) return Integer.MIN_VALUE;

        int leftMax = findMaxRec(node.left);
        int rightMax = findMaxRec(node.right);

        return Math.max(node.data, Math.max(leftMax, rightMax));
    }

    // Minimum value
    public int findMinValue() {
        return findMinRec(root);
    }

    private int findMinRec(BinaryNode node) {
        if (node == null) return Integer.MAX_VALUE;

        int leftMin = findMinRec(node.left);
        int rightMin = findMinRec(node.right);

        return Math.min(node.data, Math.min(leftMin, rightMin));
    }
}

//Main class
public class BinaryMinMaxLeaf {
    public static void main(String[] args) {
        Tree bt = new Tree();

        // Insert nodes
        bt.insert(10);
        bt.insert(20);
        bt.insert(30);
        bt.insert(40);
        bt.insert(50);

        // Preorder traversal
        System.out.println("Preorder Traversal:");
        bt.preOrder();

        // Sum of non-leaf nodes
        System.out.println("\nSum of Non-Leaf Nodes: " + bt.sumOfNonLeafNodes());

        // Maximum value
        System.out.println("Maximum Value: " + bt.findMaxValue());

        // Minimum value
        System.out.println("Minimum Value: " + bt.findMinValue());
    }
}
