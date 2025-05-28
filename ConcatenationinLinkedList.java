package data_structure1;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {
    Node head;

    public Node getHead() {
        return head;
    }

    // Insert node at end (without using temp)
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            for (Node current = head; current != null; current = current.getNext()) {
                if (current.getNext() == null) {
                    current.setNext(newNode);
                    break;
                }
            }
        }
    }

    // Display list (without using temp)
    public void display() {
        for (Node current = head; current != null; current = current.getNext()) {
            System.out.print(current.getData() + " -> ");
        }
        System.out.println("null");
    }

    // Concatenate two linked lists
    public LinkedList concat(LinkedList LL2) {
        LinkedList res = new LinkedList();

        for (Node iter = this.head; iter != null; iter = iter.getNext()) {
            res.insertLast(iter.getData());
        }

        for (Node iter = LL2.getHead(); iter != null; iter = iter.getNext()) {
            res.insertLast(iter.getData());
        }

        return res;
    }
}

public class ConcatenationinLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        System.out.print("How many elements in List 1? ");
        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            list1.insertLast(sc.nextInt());
        }

        System.out.print("How many elements in List 2? ");
        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            list2.insertLast(sc.nextInt());
        }

        System.out.println("List 1:");
        list1.display();

        System.out.println("List 2:");
        list2.display();

        LinkedList concatenated = list1.concat(list2);
        System.out.println("Concatenated List:");
        concatenated.display();

        sc.close();
    }
}
