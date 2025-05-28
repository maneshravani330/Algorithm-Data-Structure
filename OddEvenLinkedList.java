package data_structure2;

import java.util.Scanner;

public class OddEvenLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    public static void insertNode(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(data);
        }
    }

    public static void display(Node start) {
        Node curr = start;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) 
            	System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void rearrangeOddEven() {
        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;
        Node curr = head;

        while (curr != null) {
            if (curr.data % 2 != 0) {
                if (oddHead == null) oddHead = oddTail = new Node(curr.data);
                else {
                    oddTail.next = new Node(curr.data);
                    oddTail = oddTail.next;
                }
            } else {
                if (evenHead == null) evenHead = evenTail = new Node(curr.data);
                else {
                    evenTail.next = new Node(curr.data);
                    evenTail = evenTail.next;
                }
            }
            curr = curr.next;
        }

        if (oddTail != null) oddTail.next = evenHead;
        display(oddHead != null ? oddHead : evenHead);
    }

    public static void alternateOddEven() {
        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;
        Node curr = head;

        while (curr != null) {
            if (curr.data % 2 != 0) {
                if (oddHead == null) oddHead = oddTail = new Node(curr.data);
                else {
                    oddTail.next = new Node(curr.data);
                    oddTail = oddTail.next;
                }
            } else {
                if (evenHead == null) evenHead = evenTail = new Node(curr.data);
                else {
                    evenTail.next = new Node(curr.data);
                    evenTail = evenTail.next;
                }
            }
            curr = curr.next;
        }

        Node newHead = null, tail = null;
        Node oddCurr = oddHead, evenCurr = evenHead;

        while (oddCurr != null || evenCurr != null) {
            if (oddCurr != null) {
                if (newHead == null) newHead = tail = oddCurr;
                else {
                    tail.next = oddCurr;
                    tail = tail.next;
                }
                oddCurr = oddCurr.next;
            }
            if (evenCurr != null) {
                if (newHead == null) newHead = tail = evenCurr;
                else {
                    tail.next = evenCurr;
                    tail = tail.next;
                }
                evenCurr = evenCurr.next;
            }
        }
        display(newHead);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1) Enter Nodes");
            System.out.println("2) Rearrange: Odds → Evens");
            System.out.println("3) Rearrange: Alternate Odd-Even");
            System.out.println("4) Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    head = null;
                    System.out.print("Enter number of nodes: ");
                    int n = sc.nextInt();
                    System.out.println("Enter " + n + " integers:");
                    for (int i = 0; i < n; i++) {
                        insertNode(sc.nextInt());
                    }
                    break;

                case 2:
                    System.out.print("Rearranged (Odds → Evens): ");
                    rearrangeOddEven();
                    break;

                case 3:
                    System.out.print("Rearranged (Alternate Odd-Even): ");
                    alternateOddEven();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

    }
}
