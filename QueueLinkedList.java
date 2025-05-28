package data_structure;
//Queue using Linked List in Java (Simple, No Ternary)

class Node {
 int data;
 Node next;

 Node(int d) {
     data = d;
     next = null;
 }
}

class LinkedQueue {
 private Node front, rear;

 public LinkedQueue() {
     front = null;
     rear = null;
 }

 public boolean isEmpty() {
     if (front == null) {
         return true;
     } else {
         return false;
     }
 }

 public void insert(int value) {
     Node newNode = new Node(value);
     if (rear == null) {
         front = newNode;
         rear = newNode;
     } else {
         rear.next = newNode;
         rear = newNode;
     }
 }

 public int remove() {
     if (isEmpty()) {
         System.out.println("Underflow");
         return -999;
     }
     int value = front.data;
     front = front.next;
     if (front == null) {
         rear = null;
     }
     return value;
 }

 public int peek() {
     if (isEmpty()) {
         System.out.println("Queue is empty");
         return -999;
     }
     return front.data;
 }
}

public class QueueLinkedList{
 public static void main(String[] args) {
     java.util.Scanner sc = new java.util.Scanner(System.in);
     LinkedQueue queue = new LinkedQueue();

     int choice;
     int value;

     do {
         System.out.println("\nMenu:");
         System.out.println("1. Insert");
         System.out.println("2. Remove");
         System.out.println("3. Peek");
         System.out.println("4. Check if Queue is Empty");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         choice = sc.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Enter value to insert: ");
                 value = sc.nextInt();
                 queue.insert(value);
                 break;

             case 2:
                 value = queue.remove();
                 System.out.println("Removed: " + value);
                 break;

             case 3:
                 value = queue.peek();
                 System.out.println("Front element: " + value);
                 break;

             case 4:
                 if (queue.isEmpty()) {
                     System.out.println("Queue is Empty");
                 } else {
                     System.out.println("Queue is Not Empty");
                 }
                 break;

             case 5:
                 System.out.println("Exiting...");
                 break;

             default:
                 System.out.println("Invalid choice");
         }

     } while (choice != 5);

     sc.close();
 }
}

