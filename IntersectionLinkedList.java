package data_structure2;

import java.util.Scanner;

class InterNode {
    int data;
    InterNode next;

    InterNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    InterNode head;

    public void insertAtEnd(int data) {
        InterNode newNode = new InterNode(data);
        if (head == null) {
            head = newNode;
        } else {
            InterNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}
public class IntersectionLinkedList {

    public static InterNode getIntersectionNode(LinkedList list1, LinkedList list2) {
        InterNode current1 = list1.head;
        InterNode current2 = list2.head;

        while (current1 != null) {
            current2 = list2.head;
            while (current2 != null) {
                if (current1 == current2) {
                    return current1;  // Intersection found
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }

        return null;  // No intersection
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

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

        InterNode intersectionNode = getIntersectionNode(list1, list2);

        if (intersectionNode != null) {
            System.out.println("The lists intersect at node with data: " + intersectionNode.data);
        } else {
            System.out.println("The lists do not intersect.");
        }
    }
}
