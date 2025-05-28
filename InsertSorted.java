package data_structure1;

import java.util.Scanner;

class MyNode {
    int data;
    MyNode next;

    MyNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}

class SinglyList {
    MyNode head;

    // Insert in sorted order
    public void insertSorted(int d) {
        MyNode newNode = new MyNode(d);

        if (head == null || head.getData() > d) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        MyNode iter = head;
        while (iter.getNext() != null && iter.getNext().getData() < d) {
            iter = iter.getNext();
        }

        newNode.setNext(iter.getNext());
        iter.setNext(newNode);
    }

    public void display() {
        MyNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}

public class InsertSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyList list = new SinglyList();

        System.out.print("How many values do you want to insert? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = sc.nextInt();
            list.insertSorted(value);
        }

        System.out.println("Sorted Linked List:");
        list.display();
    }
}
