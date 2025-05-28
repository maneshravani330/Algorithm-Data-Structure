package data_structure;

import java.util.Scanner;

class MyNode {
    private int data;
    private MyNode next;

    public MyNode(int data) {
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

class SLinkedList {
    private MyNode head;

    public SLinkedList() {
        head = null;
    }
//insert first
    public void insertFirst(int d) {
        MyNode new_node = new MyNode(d);
        new_node.setNext(head);
        head = new_node;
    }
//insert last

    public void insert_last(int d) {
        MyNode new_node = new MyNode(d);
        if (head == null) {
            head = new_node;
            return;
        }
        MyNode iter = head;
        while (iter.getNext() != null)
            iter = iter.getNext();
        iter.setNext(new_node);
    }
//delete first
    public int deletefirst() {
        if (head == null)
            return -999;
        int d = head.getData();
        head = head.getNext();
        return d;
    }
//delete Last
    public int deleteLast() {
        if (head == null)
            return -999;
        if (head.getNext() == null) {
            int d = head.getData();
            head = null;
            return d;
        }
        MyNode iter = head;
        while (iter.getNext().getNext() != null)
            iter = iter.getNext();
        int d = iter.getNext().getData();
        iter.setNext(null);
        return d;
    }

    //insert by position
    public void insert_by_pos(int d, int pos) {
        MyNode new_node = new MyNode(d);
        if (pos <= 1 || head == null) {
            new_node.setNext(head);
            head = new_node;
            return;
        }
        MyNode iter = head;
        for (int i = 1; i < pos - 1 && iter.getNext() != null; i++)
            iter = iter.getNext();
        new_node.setNext(iter.getNext());
        iter.setNext(new_node);
    }
//delete by position
    public int delete_by_pos(int pos) {
        if (head == null)
            return -999;
        if (pos == 1) {
            int d = head.getData();
            head = head.getNext();
            return d;
        }
        MyNode iter = head;
        for (int i = 1; i < pos - 1 && iter.getNext() != null; i++)
            iter = iter.getNext();
        if (iter.getNext() == null)
            return -999;
        int d = iter.getNext().getData();
        iter.setNext(iter.getNext().getNext());
        return d;
    }

    //insert before 
    public void insert_before(int d, int key) {
        MyNode new_node = new MyNode(d);
        if (head == null || head.getData() == key) {
            new_node.setNext(head);
            head = new_node;
            return;
        }
        MyNode iter = head;
        while (iter.getNext() != null && iter.getNext().getData() != key)
            iter = iter.getNext();
        if (iter.getNext() == null) {
            System.out.println("Key not found. Insertion not possible.");
            return;
        }
        new_node.setNext(iter.getNext());
        iter.setNext(new_node);
    }
//insert after
    public void insert_after(int d, int key) {
        MyNode new_node = new MyNode(d);
        MyNode iter = head;
        while (iter != null && iter.getData() != key)
            iter = iter.getNext();
        if (iter == null) {
            System.out.println("Key not found. Insertion not possible.");
            return;
        }
        new_node.setNext(iter.getNext());
        iter.setNext(new_node);
    }
//display
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        MyNode iter = head;
        while (iter != null) {
            System.out.print(iter.getData() + " -> ");
            iter = iter.getNext();
        }
        System.out.println("NULL");
    }
}

//class
public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLinkedList ll = new SLinkedList();
        int choice, data, pos, key;

        do {
            System.out.println("\n--- Singly Linked List Menu ---");
            System.out.println("1. Insert at First");
            System.out.println("2. Insert at Last");
            System.out.println("3. Delete First");
            System.out.println("4. Delete Last");
            System.out.println("5. Insert by Position");
            System.out.println("6. Delete by Position");
            System.out.println("7. Insert Before Key");
            System.out.println("8. Insert After Key");
            System.out.println("9. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    ll.insertFirst(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    ll.insert_last(data);
                    break;
                case 3:
                    System.out.println("Deleted: " + ll.deletefirst());
                    break;
                case 4:
                    System.out.println("Deleted: " + ll.deleteLast());
                    break;
                case 5:
                    System.out.print("Enter data and position: ");
                    data = sc.nextInt();
                    pos = sc.nextInt();
                    ll.insert_by_pos(data, pos);
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    System.out.println("Deleted: " + ll.delete_by_pos(pos));
                    break;
                case 7:
                    System.out.print("Enter data and key: ");
                    data = sc.nextInt();
                    key = sc.nextInt();
                    ll.insert_before(data, key);
                    break;
                case 8:
                    System.out.print("Enter data and key: ");
                    data = sc.nextInt();
                    key = sc.nextInt();
                    ll.insert_after(data, key);
                    break;
                case 9:
                    ll.display();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
    }
}
