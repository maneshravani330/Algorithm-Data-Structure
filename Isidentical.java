package data_structure2;

import java.util.Scanner;

class IsNode {
    int data;
    IsNode next;

    IsNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public IsNode getNext() {
        return next;
    }

    public void setNext(IsNode next) {
        this.next = next;
    }
}

class SLinkedList {
    IsNode head;

    public void insertAtEnd(int data) {
        IsNode newNode = new IsNode(data);
        if (head == null) {
            head = newNode;
        } else {
            IsNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void display() {
        IsNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}

public class Isidentical {
    public static boolean isIdentical(SLinkedList ll1, SLinkedList ll2) {
        IsNode iter1 = ll1.head;
        IsNode iter2 = ll2.head;

        while (iter1 != null && iter2 != null) {
            if (iter1.getData() != iter2.getData()) {
                return false; 
            }
            iter1 = iter1.getNext();
            iter2 = iter2.getNext();
        }
        return (iter1 == null && iter2 == null);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLinkedList list1 = new SLinkedList();
        SLinkedList list2 = new SLinkedList();
        
        System.out.print("Enter number of elements for List 1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements for List 1:");
        for (int i = 0; i < n1; i++) {
            list1.insertAtEnd(sc.nextInt());
        }

        System.out.print("Enter number of elements for List 2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements for List 2:");
        for (int i = 0; i < n2; i++) {
            list2.insertAtEnd(sc.nextInt());
        }

        System.out.println("\nList 1:");
        list1.display();

        System.out.println("List 2:");
        list2.display();

        if (isIdentical(list1, list2)) {
            System.out.println("The two linked lists are identical.");
        } else {
            System.out.println("The two linked lists are not identical.");
        }
 
    }
}
