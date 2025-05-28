package data_structure2;

import java.util.Scanner;

class DDLNode {
    private int data;
    private DDLNode prev, next;

    public DDLNode(int d) 
    {
        data = d;
        prev = next = null;
    }

    public void setData(int d)
    {
    	data = d;
    }
    public int getData()
    {
    	return data; 
    }

    public void setPrev(DDLNode p)
    {
    	prev = p; 
    }
    public DDLNode getPrev() 
    {
    	return prev; 
    }

    public void setNext(DDLNode n)
    { 
    	next = n; 
    }
    public DDLNode getNext() 
    {
    	return next; 
    }
}

class DoublyLL {
    private DDLNode head;

    public DoublyLL()
    {
    	head = null; 
    }
    //insert First
    public void insertFirst(int d)
    {
        DDLNode new_node = new DDLNode(d);
        if (head != null)
        {
            new_node.setNext(head);
            head.setPrev(new_node);
        }
        head = new_node;
    }
    //insert Last
    public void insertLast(int d) {
        DDLNode new_node = new DDLNode(d);
        if (head == null) {
            head = new_node;
            return;
        }
        DDLNode iter = head;
        while (iter.getNext() != null) {
            iter = iter.getNext();
        }
        iter.setNext(new_node);
        new_node.setPrev(iter);
    }
    //delete First
    public int deleteFirst() {
        if (head == null) return -999;
        int val = head.getData();
        head = head.getNext();
        if (head != null) head.setPrev(null);
        return val;
    }
    //delete Last
    public int deleteLast() {
        if (head == null) return -999;
        if (head.getNext() == null) {
            int val = head.getData();
            head = null;
            return val;
        }
        DDLNode iter = head;
        while (iter.getNext() != null) {
            iter = iter.getNext();
        }
        int val = iter.getData();
        iter.getPrev().setNext(null);
        return val;
    }
    //insert by position
    public void insertByPosition(int pos, int d) {
        if (pos <= 0) {
            System.out.println("Position must be 1 or more");
            return;
        }
        if (pos == 1) {
            insertFirst(d);
            return;
        }
        DDLNode iter = head;
        for (int i = 1; i < pos - 1 && iter != null; i++) {
            iter = iter.getNext();
        }
        if (iter == null) {
            System.out.println("Position out of range");
            return;
        }
        DDLNode new_node = new DDLNode(d);
        new_node.setNext(iter.getNext());
        new_node.setPrev(iter);
        if (iter.getNext() != null) {
            iter.getNext().setPrev(new_node);
        }
        iter.setNext(new_node);
    }
    // delete by position
    public int deleteByPosition(int pos) {
        if (head == null || pos <= 0) return -999;
        if (pos == 1) return deleteFirst();
        DDLNode iter = head;
        for (int i = 1; i < pos && iter != null; i++) {
            iter = iter.getNext();
        }
        if (iter == null) return -999;
        int val = iter.getData();
        if (iter.getPrev() != null) iter.getPrev().setNext(iter.getNext());
        if (iter.getNext() != null) iter.getNext().setPrev(iter.getPrev());
        return val;
    }
    //display
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        for (DDLNode iter = head; iter != null; iter = iter.getNext()) {
            System.out.print(iter.getData() + " <-> ");
        }
        System.out.println("null");
    }
    //display Reverse
    public void displayReverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        DDLNode iter = head;
        while (iter.getNext() != null) {
            iter = iter.getNext();
        }
        while (iter != null) {
            System.out.print(iter.getData() + " <-> ");
            iter = iter.getPrev();
        }
        System.out.println("null");
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLL dll = new DoublyLL();
        int ch, d, pos;

        do {
            System.out.println("\n Doubly Linked List Menu");
            System.out.println("1 Insert First");
            System.out.println("2 Insert Last");
            System.out.println("3 Insert by Position");
            System.out.println("4 Delete First");
            System.out.println("5 Delete Last");
            System.out.println("6 Delete by Position");
            System.out.println("7 Display");
            System.out.println("8 Display Reverse");
            System.out.println("9 Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter data: ");
                    d = sc.nextInt();
                    dll.insertFirst(d);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    d = sc.nextInt();
                    dll.insertLast(d);
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter data: ");
                    d = sc.nextInt();
                    dll.insertByPosition(pos, d);
                    break;
                case 4:
                    d = dll.deleteFirst();
                    if (d == -999)
                        System.out.println("List is empty");
                    else
                        System.out.println("Deleted element is " + d);
                    break;
                case 5:
                    d = dll.deleteLast();
                    if (d == -999)
                        System.out.println("List is empty");
                    else
                        System.out.println("Deleted element is " + d);
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    pos = sc.nextInt();
                    d = dll.deleteByPosition(pos);
                    if (d == -999)
                        System.out.println("Invalid position or list is empty");
                    else
                        System.out.println("Deleted element is " + d);
                    break;
                case 7:
                    dll.display();
                    break;
                case 8:
                    dll.displayReverse();
                    break;
                case 9:
                    System.out.println("Program ended");
                    break;
                default:
                    System.out.println("Wrong choice");
            }

        } while (ch != 9);

    }
}
