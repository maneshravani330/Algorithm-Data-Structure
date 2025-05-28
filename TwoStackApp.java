package data_structure;

import java.util.Scanner;

class TwoCStack {
    private int[] arr;
    private int topA, topB;

    public TwoCStack() {
        arr = new int[50];
        topA = -1;
        topB = arr.length;
    }

    public TwoCStack(int size) {
        arr = new int[size];
        topA = -1;
        topB = arr.length;
    }

    public boolean isFull() {
        return (topB - topA) == 1;
    }

    public boolean isEmptyA() {
        return topA == -1;
    }

    public boolean isEmptyB() {
        return topB == arr.length;
    }

    public void pushA(int d) {
        if (!isFull()) {
            topA++;
            arr[topA] = d;
        } else {
            System.out.println("Stack A Overflow");
        }
    }

    public void pushB(int d) {
        if (!isFull()) {
            topB--;
            arr[topB] = d;
        } else {
            System.out.println("Stack B Overflow");
        }
    }

    public int popA() {
        if (!isEmptyA()) {
            return arr[topA--];
        } else {
            System.out.println("Stack A Underflow");
            return -999;
        }
    }

    public int popB() {
        if (!isEmptyB()) {
            return arr[topB++];
        } else {
            System.out.println("Stack B Underflow");
            return -999;
        }
    }
}

public class TwoStackApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TwoCStack stack = new TwoCStack(10);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Push in Stack A");
            System.out.println("2. Pop from Stack A");
            System.out.println("3. Push in Stack B");
            System.out.println("4. Pop from Stack B");
            System.out.println("5. Check if Stack is Full");
            System.out.println("6. Check if Stack A is Empty");
            System.out.println("7. Check if Stack B is Empty");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int value;
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push in Stack A: ");
                    value = sc.nextInt();
                    stack.pushA(value);
                    break;

                case 2:
                    System.out.println("Popped from Stack A: " + stack.popA());
                    break;

                case 3:
                    System.out.print("Enter value to push in Stack B: ");
                    value = sc.nextInt();
                    stack.pushB(value);
                    break;

                case 4:
                    System.out.println("Popped from Stack B: " + stack.popB());
                    break;

                case 5:
                    if (stack.isFull()) {
                        System.out.println("Stack is Full");
                    } else {
                        System.out.println("Stack is Not Full");
                    }
                    break;

                case 6:
                    if (stack.isEmptyA()) {
                        System.out.println("Stack A is Empty");
                    } else {
                        System.out.println("Stack A is Not Empty");
                    }
                    break;

                case 7:
                    if (stack.isEmptyB()) {
                        System.out.println("Stack B is Empty");
                    } else {
                        System.out.println("Stack B is Not Empty");
                    }
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 8);

        sc.close();
    }
}
