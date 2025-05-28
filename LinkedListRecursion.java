package data_structure3;

class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

class LinkedList {
    private ListNode head;

    public void setHead(ListNode head) {
        this.head = head;
    }

    public ListNode getHead() {
        return head;
    }

    // Insert node at the end
    public void insert(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }

    // For regular display
    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.getData()).append(" -> ");
            temp = temp.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}

public class LinkedListRecursion {

    // Recursive reverse display (doesn't modify the list)
    static void disp(ListNode temp) {
        if (temp == null) return;
        disp(temp.getNext());
        System.out.print(temp.getData() + " ");
    }

    // Actual recursive reversal of the linked list
    public static ListNode reverse(ListNode head) {
        if (head == null || head.getNext() == null)
            return head;

        ListNode temp = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return temp;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Original List:");
        list.display();

        System.out.print("Reverse Display (using recursion): ");
        disp(list.getHead());
        System.out.println();

        list.setHead(reverse(list.getHead()));
        System.out.println("List after actual reversal:");
        System.out.println(list);
    }
}
