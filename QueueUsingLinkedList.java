package data_structure1;

import java.util.Scanner;

// Node class
class QueueNode {
    int data;
    QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue using Linked List
class LinkedListQueue {
    private QueueNode front, rear;

    public LinkedListQueue() {
        front = rear = null;
    }

    // Enqueue operation
    public void enqueue(int data) {
        QueueNode newNode = new QueueNode(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " enqueued to queue.");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow: Queue is empty.");
            return -999;
        }
        int removed = front.data;
        front = front.next;
        if (front == null) rear = null;
        return removed;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -999;
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListQueue queue = new LinkedListQueue();
        int ch, e;

        do {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if queue is empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    e = sc.nextInt();
                    queue.enqueue(e);
                    break;
                case 2:
                    int removed = queue.dequeue();
                    if (removed != -999)
                        System.out.println("Dequeued element: " + removed);
                    break;
                case 3:
                    int front = queue.peek();
                    if (front != -999)
                        System.out.println("Front element: " + front);
                    break;
                case 4:
                    if (queue.isEmpty())
                        System.out.println("Queue is empty.");
                    else
                        System.out.println("Queue is not empty.");
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
