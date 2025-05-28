package data_structure2;

import java.util.ArrayList;
import java.util.Scanner;

class PalNode {
    int data;
    PalNode next;

    PalNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SLList {
    PalNode head;

    public void insertAtEnd(int data) {
        PalNode newNode = new PalNode(data);
        if (head == null) {
            head = newNode;
        } else {
            PalNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        PalNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public boolean isPalindrome() {
        ArrayList<Integer> list = new ArrayList<>();
        PalNode current = head;

        while (current != null) {
            list.add(current.data);
            current = current.next;
        }

        int start = 0, end = list.size() - 1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

public class IsPalindromeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLList list = new SLList();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.insertAtEnd(sc.nextInt());
        }

        System.out.println("Linked List:");
        list.display();

        if (list.isPalindrome()) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
