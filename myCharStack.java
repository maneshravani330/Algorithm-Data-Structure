package data_structure;

import java.util.Scanner;

class charStack {
    private char arr[];
    private int top;

    public charStack() {
        arr = new char[10];
        top = -1;
    }

    public charStack(int s) {
        arr = new char[s];
        top = -1;
    }

    public void push(char e) {
        if (top == arr.length - 1) {
            System.out.println("Overflow");
            return;
        }
        top = top + 1;
        arr[top] = e;
    }

    public char pop() {
        char d = '\0';
        if (top == -1) {
            System.out.println("Underflow...");
            return d;
        }
        d = arr[top];
        top = top - 1;
        return d;
    }

    public char peek() {
        char d = '\0';
        if (top == -1) {
            System.out.println("Underflow");
            return d;
        }
        System.out.println("Toppest element:");
        return arr[top];
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class myCharStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        char e;
        charStack s1 = new charStack();

        do {
            System.out.println("Menu");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.println("5. Check if stack is full");
            System.out.println("6. Check if stack is empty");
            System.out.println("Enter Your Choice (1...6):");

            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter character to push:");
                    e = sc.next().charAt(0);
                    s1.push(e);
                    break;

                case 2:
                    System.out.println("Popped element: " + s1.pop());
                    break;

                case 3:
                    System.out.println("Peeked element: " + s1.peek());
                    break;

                case 4:
                    System.out.println("\nThe End");
                    break;

                case 5:
                    if (s1.isFull()) {
                        System.out.println("The stack is full.");
                    } else {
                        System.out.println("The stack is not full.");
                    }
                    break;

                case 6:
                    if (s1.isEmpty()) {
                        System.out.println("The stack is empty.");
                    } else {
                        System.out.println("The stack is not empty.");
                    }
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        } while (ch != 6); 
    }
}
