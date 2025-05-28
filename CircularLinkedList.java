package data_structure2;

import java.util.Scanner;

// Node class
class IntNode {
    private int data;
    private IntNode next;

    public IntNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public IntNode getNext() {
        return next;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }
}

// Circular Linked List class
class CircularLL {
    private IntNode last;

    public IntNode getLast() {
        return last;
    }

    public void setLast(IntNode last) {
        this.last = last;
    }

    // Insert first
    public void insertFirst(int d) {
        IntNode newNode = new IntNode(d);
        if (last == null) {
            last = newNode;
            last.setNext(last);
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
        }
        System.out.println(d + " inserted at beginning.");
    }

    // Insert last
    public void insertLast(int d) {
        IntNode newNode = new IntNode(d);
        if (last == null) {
            last = newNode;
            last.setNext(last);
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
            last = newNode;
        }
        System.out.println(d + " inserted at end.");
    }

    // Delete first
    public int deleteFirst() {
        if (last == null) 
        	return -999;
        IntNode first = last.getNext();
        int d = first.getData();

        if (last == first) {
            last = null;
        } else {
            last.setNext(first.getNext());
        }

        return d;
    }

    // Delete last
    public int deleteLast() {
        if (last == null) return -999;
        IntNode iter = last.getNext();
        int d = last.getData();

        if (iter == last) {
            last = null;
        } else {
            while (iter.getNext() != last) {
                iter = iter.getNext();
            }
            iter.setNext(last.getNext());
            last = iter;
        }

        return d;
    }

    // Display
    public void display() {
        if (last == null) {
            System.out.println("List is empty...");
            return;
        }
        IntNode iter = last.getNext();
        System.out.print("List: ");
        do {
            System.out.print(iter.getData() + " -> ");
            iter = iter.getNext();
        } while (iter != last.getNext());
        System.out.println("back to head");
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLL list = new CircularLL();
        int ch, val;

        do {
            System.out.println("\n Circular Linked List Menu");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Delete First");
            System.out.println("4. Delete Last");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter element to insert at beginning: ");
                    val = sc.nextInt();
                    list.insertFirst(val);
                    break;
                case 2:
                    System.out.print("Enter element to insert at end: ");
                    val = sc.nextInt();
                    list.insertLast(val);
                    break;
                case 3:
                    val = list.deleteFirst();
                    if (val != -999)
                        System.out.println("Deleted from beginning: " + val);
                    else
                        System.out.println("List is empty.");
                    break;
                case 4:
                    val = list.deleteLast();
                    if (val != -999)
                        System.out.println("Deleted from end: " + val);
                    else
                        System.out.println("List is empty.");
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (ch != 6);
    }
}
