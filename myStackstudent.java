package exam;

import java.util.Scanner;

class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name;
    }
}

class studentStack {
    private Student[] arr;
    private int top;

    public studentStack() {
        arr = new Student[10];
        top = -1;
    }

    public studentStack(int s) {
        arr = new Student[s];
        top = -1;
    }

    public void push(Student s) {
        if (top == arr.length - 1) {
            System.out.println("Overflow");
        } else {
            top++;
            arr[top] = s;
        }
    }

    public Student pop() {
        if (top == -1) {
            System.out.println("Underflow...");
            return null;
        } else {
            Student temp = arr[top];
            top--;
            return temp;
        }
    }

    public Student peek() {
        if (top == -1) {
            System.out.println("Underflow");
            return null;
        } else {
            return arr[top];
        }
    }

    public boolean isFull() {
        if (top == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}

public class myStackstudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        studentStack s1 = new studentStack();
        int ch, rno;
        String name;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.println("5. Check if stack is full");
            System.out.println("6. Check if stack is empty");
            System.out.print("Enter Your Choice (1 to 6): ");
            ch = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    rno = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    Student s = new Student(rno, name);
                    s1.push(s);
                    break;

                case 2:
                    Student popped = s1.pop();
                    if (popped != null) {
                        System.out.println("Popped: " + popped);
                    }
                    break;

                case 3:
                    Student topStudent = s1.peek();
                    if (topStudent != null) {
                        System.out.println("Top Element: " + topStudent);
                    }
                    break;

                case 4:
                    System.out.println("The End");
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
                    System.out.println("Invalid Choice");
            }

        } while (ch != 4);
    }
}
