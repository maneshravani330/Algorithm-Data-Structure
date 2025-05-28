package data_structure;

class intNode {
    private int data;
    private intNode next;

    public intNode() {
        data = 0;
        next = null;
    }

    public intNode(int d) {
        data = d;
        next = null;
    }

    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }

    public void setNext(intNode n) {
        next = n;
    }

    public intNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return data + "";
    }
}

// Linked list class
public class LinkedList {
    private intNode head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtEnd(int value) {
        intNode newNode = new intNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            intNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public void insertAtBeginning(int value) {
        intNode newNode = new intNode(value);
        newNode.setNext(head);
        head = newNode;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
        } else {
            head = head.getNext();
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
        } else {
            intNode temp = head;
            System.out.print("Linked List: ");
            while (temp != null) {
                System.out.print(temp.getData() + " -> ");
                temp = temp.getNext();
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.display();        
        list.deleteFirst();
        list.display();        
    }
}
