package data_structure2;

import java.util.Scanner;

class CountNode {
    int data;
    CountNode next;

    CountNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class CountLinkedList {
    CountNode head;

    public void insertAtEnd(int data) {
        CountNode newNode = new CountNode(data);
        if (head == null) {
            head = newNode;
        } else {
            CountNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int getLength() {
        int length = 0;
        CountNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}

public class CountListLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountLinkedList list = new CountLinkedList();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.insertAtEnd(sc.nextInt());
        }

        System.out.println("Length of the linked list: " + list.getLength());
    }
}
