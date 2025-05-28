package data_structure2;

import java.util.*;

class MyNode {
    int data;
    MyNode next;

    MyNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Tortoise_hare_Algorithm {

    public static MyNode detectCycleStart(MyNode head) {
        MyNode slow = head;
        MyNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MyNode> nodeList = new ArrayList<>();
        MyNode head = null, tail = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter data for node " + (i + 1) + ": ");
            int val = sc.nextInt();
            MyNode newNode = new MyNode(val);
            nodeList.add(newNode);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter position to create cycle: ");
        int pos = sc.nextInt();
        if (pos > 0 && pos <= n) {
            tail.next = nodeList.get(pos - 1); 
        }

        MyNode cycleStart = detectCycleStart(head);

        if (cycleStart != null) {
            System.out.println("Cycle detected starting at node with value: " + cycleStart.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
