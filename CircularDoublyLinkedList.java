package data_structure2;

import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

public class CircularDoublyLinkedList {
    private Node head = null;

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode.prev = newNode;
            head = newNode;
        } else {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            head.prev = newNode;
            last.next = newNode;

            head = newNode;
        }
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode.prev = newNode;
            head = newNode;
        } else {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == head) {
            head = null;
        } else {
            Node last = head.prev;

            head = head.next;
            head.prev = last;
            last.next = head;
        }
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == head) {
            head = null;
        } else {
            Node last = head.prev;
            Node secondLast = last.prev;

            secondLast.next = head;
            head.prev = secondLast;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, data, pos;

        do {
            System.out.println("\n Circular Doubly Linked List ");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Delete First");
            System.out.println("4. Delete Last");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertFirst(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertLast(data);
                    break;
                case 3:
                    list.deleteFirst();
                    break;
                case 4:
                    list.deleteLast();
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (choice != 0);
    }
}
