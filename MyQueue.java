package data_structure;

class intQueue {
    private int arr[];
    private int front, rear;

    public intQueue() {
        arr = new int[10];
        front = rear = -1;
    }

    public intQueue(int s) {
        arr = new int[s];
        front = rear = -1;
    }

    public boolean isFull() {
        if (rear == arr.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (front == -1 || front > rear) {
            return true;
        }
        return false;
    }

    public void insert(int d) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        if (front == -1) {
            front = 0; 
        }
        rear = rear + 1;
        arr[rear] = d;
    }

    public int remove() {
        int d = -999;
        if (isEmpty()) {
            System.out.println("Underflow");
            return d;
        }
        d = arr[front];
        front = front + 1;
        return d;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -999;  
        }
        return arr[front];
    }
}

public class MyQueue {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        intQueue queue = new intQueue(5); // Initialize queue with size 5

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
                    System.out.println("Removed: " + queue.remove());
                    break;

                case 3:
                    System.out.println("Front element: " + queue.peek());
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
