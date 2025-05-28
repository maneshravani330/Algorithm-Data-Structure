package data_structure6;

import java.util.Scanner;

// Enum for status of each record
enum type_of_record {EMPTY, DELETED, OCCUPIED}

// Class to represent a student record
class Student {
    private int rollNo;
    private String name;
    private float marks;
    int age;

    public Student(int rollNo, String name, float marks, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public float getMarks() {
        return marks;
    }
}

// Class to represent a slot in the hash table
class Record {
    Student info;
    type_of_record status;
}

// Hash table implementation with linear probing
class Hash_LinearProbing {
    Record[] table;

    public Hash_LinearProbing() {
        table = new Record[10];
        for (int i = 0; i < 10; i++) {
            table[i] = new Record();
            table[i].status = type_of_record.EMPTY;
        }
    }

    public void insert(Student s) {
        int key = s.getRollNo();
        int h = hash(key);
        int location = h;

        for (int i = 0; i < 10; i++) {
            if (table[location].status == type_of_record.EMPTY || table[location].status == type_of_record.DELETED) {
                table[location].info = s;
                table[location].status = type_of_record.OCCUPIED;
                System.out.println("Record inserted");
                return;
            }

            if (table[location].info.getRollNo() == key) {
                System.out.println("Duplicate key");
                return;
            }

            location = (h + i + 1) % 10;
        }

        System.out.println("Record can't be inserted: Table overflow");
    }

    public int search(int key) {
        int h = hash(key);
        int location = h;

        for (int i = 0; i < 10; i++) {
            if (table[location].status == type_of_record.EMPTY)
                return -1;

            if (table[location].status == type_of_record.OCCUPIED &&
                table[location].info.getRollNo() == key)
                return location;

            location = (h + i + 1) % 10;
        }

        return -1;
    }

    public void delete(int key) {
        int location = search(key);
        if (location == -1)
            System.out.println("Key not found");
        else
            table[location].status = type_of_record.DELETED;
    }

    public int hash(int key) {
        return key % 10;
    }

    public void display() {
        for (int i = 0; i < 10; i++) {
            System.out.print("\n" + i + " -> ");
            if (table[i].status == type_of_record.OCCUPIED) {
                Student s = table[i].info;
                System.out.println("Occupied | Roll: " + s.getRollNo() + ", Name: " + s.getName() + ", "
                		+ "Marks: " + s.getMarks() + ", Age: " + s.age);
            } else if (table[i].status == type_of_record.DELETED) {
                System.out.println("Deleted");
            } else {
                System.out.println("Empty");
            }
        }
    }
}

// Main class with sample usage
public class Hash_LinearProbing_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hash_LinearProbing hl = new Hash_LinearProbing();

        // Inserting student records with roll numbers 1, 2, 3, 4
        hl.insert(new Student(1, "Shravani", 95.0f, 20));
        hl.insert(new Student(2, "Savi", 88.5f, 19));
        hl.insert(new Student(3, "Shree", 91.0f, 21));
        hl.insert(new Student(4, "Shiv", 84.0f, 20));

        // Display current table
        hl.display();

    }
}
