package data_structure1;

import java.util.Scanner;

// Node class
class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack using LinkedList
class LinkedListStack {
    private StackNode top;

    public LinkedListStack() {
        top = null;
    }

    // Push operation
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed to stack.");
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Underflow: Stack is empty.");
            return -999;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Underflow: Stack is empty.");
            return -999;
        }
        return top.data;
    }

    // isEmpty check
    public boolean isEmpty() {
        return top == null;
    }
}

// Main class
public class StackUsingLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListStack stack = new LinkedListStack();
        int ch, e;

        do {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if stack is empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter element to push: ");
                    e = sc.nextInt();
                    stack.push(e);
                    break;
                case 2:
                    int popped = stack.pop();
                    if (popped != -999)
                        System.out.println("Popped element: " + popped);
                    break;
                case 3:
                    int top = stack.peek();
                    if (top != -999)
                        System.out.println("Top element: " + top);
                    break;
                case 4:
                    if (stack.isEmpty())
                        System.out.println("Stack is empty.");
                    else
                        System.out.println("Stack is not empty.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (ch != 5);

    }
}
