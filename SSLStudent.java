package data_structure2;

import java.util.Scanner;

public class SSLStudent {

    static class StudentNode {
        int rollNo;
        String name;
        StudentNode next;

        StudentNode(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
            this.next = null;
        }
    }

    private StudentNode head = null;

    // Insert at end
    public void insertStudent(int rollNo, String name) {
        StudentNode newNode = new StudentNode(rollNo, name);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Insert at beginning
    public void insertFirst(int rollNo, String name) {
        StudentNode newNode = new StudentNode(rollNo, name);
        newNode.next = head;
        head = newNode;
    }

    // Delete by roll number
    public void deleteStudent(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student with rollNo " + rollNo + " deleted.");
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNo != rollNo) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Student with rollNo " + rollNo + " deleted.");
        }
    }

    // Display all students
    public void displayStudents() {
        if (head == null) {
            System.out.println("No students to display.");
            return;
        }
        for (StudentNode current = head; current != null; current = current.next) {
            System.out.print("[" + current.rollNo + ", " + current.name + "] -> ");
        }
        System.out.println("null");
    }

    // Main menu
    public static void main(String[] args) {
        SSLStudent list = new SSLStudent();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Insert Student at End");
            System.out.println("2. Insert Student at Start");
            System.out.println("3. Delete Student by Roll No");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int rollNo;
            String name;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    list.insertStudent(rollNo, name);
                    break;
                case 2:
                    System.out.print("Enter Roll No: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    list.insertFirst(rollNo, name);
                    break;
                case 3:
                    System.out.print("Enter Roll No to delete: ");
                    rollNo = sc.nextInt();
                    list.deleteStudent(rollNo);
                    break;
                case 4:
                    list.displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }
}
