package data_structure1;

import java.util.Scanner;

class IntNode {
    int data;
    IntNode next;

    IntNode(int data) {
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

class SLinkedList {
    IntNode head;

    public void insertAtEnd(int data) {
        IntNode newNode = new IntNode(data);
        
        if (head == null) {
            head = newNode;
        } else {
            IntNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            
            current.setNext(newNode);
        }
    }

    public void display() {
        IntNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    
    public void deleteAfterData(int key) {
        IntNode iter = head;
        while (iter != null) {
            if (iter.getData() == key && iter.getNext() != null) {
                iter.setNext(iter.getNext().getNext()); 
                System.out.println("Node deleted after data: " + key);
                return;
            }
            iter = iter.getNext();
        }
        System.out.println("Key not found or no node after key.");
    }

   
    public void deleteBeforeData(int key) {
        if (head == null || head.getNext() == null) {
            System.out.println("No node before the given key.");
            return;
        }

        IntNode prev = null;
        IntNode curr = head;
        IntNode next = head.getNext();

        if (next.getData() == key) {
            head = head.getNext(); // Delete head
            System.out.println("Node before key deleted.");
            return;
        }

        while (next != null && next.getData() != key) {
            prev = curr;
            curr = next;
            next = next.getNext();
        }

        if (next != null) {
            prev.setNext(next); 
            System.out.println("Node before key deleted.");
        } else {
            System.out.println("Key not found.");
        }
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLinkedList list = new SLinkedList();
        int choice, data, key;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Insert at End");
            System.out.println("2. Display List");
            System.out.println("3. Delete After Data");
            System.out.println("4. Delete Before Data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.print("Enter key after");
                    key = sc.nextInt();
                    list.deleteAfterData(key);
                    break;
                case 4:
                    System.out.print("Enter key before");
                    key = sc.nextInt();
                    list.deleteBeforeData(key);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 5);
    }
}
