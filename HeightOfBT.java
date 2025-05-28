package exam;

import java.util.LinkedList;
import java.util.Queue;

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

    public BTNode getLeft() {
        return left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setLeft(BTNode l) {
        left = l;
    }

    public void setRight(BTNode r) {
        right = r;
    }
}
public class HeightOfBT {
    private BTNode root;

    public void setRoot(BTNode r) {
        root = r;
    }

    public int find_ht() {
        if (root == null)
            return 0;

        BTNode iter;
        BTNode d = new BTNode(-999);  
        Queue<BTNode> q = new LinkedList<>();
        int cnt = 0;

        q.add(root);
        q.add(d);

        while (!q.isEmpty()) {
            iter = q.remove();

            if (iter.getData() == -999) {
                cnt++;
                if (!q.isEmpty()) {
                    q.add(d);  
                }
                continue;
            }

            if (iter.getLeft() != null)
                q.add(iter.getLeft());

            if (iter.getRight() != null)
                q.add(iter.getRight());
        }

        return cnt;
    }

    public static void main(String[] args) {
        HeightOfBT tree = new HeightOfBT();

        BTNode root = new BTNode(1);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(3);
        BTNode node4 = new BTNode(4);
        BTNode node5 = new BTNode(5);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        tree.setRoot(root);

        System.out.println("Height of Binary Tree: " + tree.find_ht());  
    }
}
