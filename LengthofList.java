package data_structure3;

class ListofNode {
    private int data;
    private ListofNode next;

    public ListofNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public ListofNode getNext() {
        return next;
    }

    public void setNext(ListofNode next) {
        this.next = next;
    }
}

class LinkedofList {
    private ListofNode head;

    public ListofNode getHead() {
        return head;
    }

    public void setHead(ListofNode head) {
        this.head = head;
    }

    // Insert a new node at the end
    public void insert(int data) {
        ListofNode newNode = new ListofNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListofNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }

    // Recursive function to find the length of the list
    public int length(ListofNode p) {
        if (p == null) return 0;
        return 1 + length(p.getNext());
    }

    // Recursive function to calculate the sum of all node data
    public int sum_nodes(ListofNode p) {
        if (p == null) return 0;
        return p.getData() + sum_nodes(p.getNext());
    }
}

public class LengthofList {
    public static void main(String[] args) {
        LinkedofList ll = new LinkedofList();
        ll.insert(10);
        ll.insert(20);
        ll.insert(30);
        ll.insert(40);
        ll.insert(50);

        System.out.println("Length of list = " + ll.length(ll.getHead()));
        System.out.println("Sum of nodes = " + ll.sum_nodes(ll.getHead()));
    }
}
