package data_structure;

import java.util.Scanner;

class intCircularQueue {
    private int arr[];
    private int rear, front;

    public intCircularQueue() {
        arr = new int[10];
        rear = front = -1;
    }

    public intCircularQueue(int s) {
        arr = new int[s];
        rear = front = -1;
    }

    public boolean isFull() {
        if ((front == 0 && rear == arr.length - 1) || (front == rear + 1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void insert(int d) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        if (rear == arr.length - 1 && front != 0) {
            rear = 0;
        } else {
            rear = (rear + 1) % arr.length;
        }

        arr[rear] = d;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -999;
        }

        int d = arr[front];

        if (front == rear) { // only one element
            front = rear = -1;
        } else {
            front = (front + 1) % arr.length;
        }

        return d;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -999;
        } else {
            return arr[front];
        }
    }
}

public class MyCircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        intCircularQueue queue = new intCircularQueue(5);
        int choice, value;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Peek");
            System.out.println("4. Check if Queue is Full");
            System.out.println("5. Check if Queue is Empty");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    queue.insert(value);
                    break;

                case 2:
                    int removed = queue.remove();
                    if (removed != -999) {
                        System.out.println("Removed: " + removed);
                    }
                    break;

                case 3:
                    int front = queue.peek();
                    if (front != -999) {
                        System.out.println("Front element: " + front);
                    }
                    break;

                case 4:
                    if (queue.isFull()) {
                        System.out.println("Queue is Full");
                    } else {
                        System.out.println("Queue is Not Full");
                    }
                    break;

                case 5:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is Empty");
                    } else {
                        System.out.println("Queue is Not Empty");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
