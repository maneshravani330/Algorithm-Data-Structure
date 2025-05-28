package data_structure6;

import java.util.Scanner;

class Student1 {
    private int rollNo;
    private String name;
    private int age;

    public Student1(int rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Record_Sep_Node {
    Student1 info;
    Record_Sep_Node next;
}

class Hash_Seperate_Chaining {
    Record_Sep_Node table[];

    public Hash_Seperate_Chaining() {
        table = new Record_Sep_Node[10];
        for (int i = 0; i < 10; i++)
            table[i] = new Record_Sep_Node();
    }

    public void insert(Student1 student) {
        int h, key;
        Record_Sep_Node tmp;

        key = student.getRollNo();

        if (search(key) != -1) {
            System.out.print("Duplicate key\n");
            return;
        }
        h = hash(key);
        tmp = new Record_Sep_Node();
        tmp.info = student;
        tmp.next = table[h];
        table[h] = tmp;
    }

    int search(int key) {
        int h;
        Record_Sep_Node ptr;
        h = hash(key);
        ptr = table[h];
        while (ptr != null && ptr.info != null) {
            if (ptr.info.getRollNo() == key)
                return h;
            ptr = ptr.next;
        }
        return -1;
    }

    int hash(int key) {
        return (key % 10);
    }

    void del(int key) {
        int h;
        Record_Sep_Node tmp, ptr;
        h = hash(key);

        if (table[h] == null) {
            System.out.print(key + " not found\n");
            return;
        }
        if (table[h].info.getRollNo() == key) {
            tmp = table[h];
            table[h] = table[h].next;
            return;
        }
        ptr = table[h];
        while (ptr.next != null) {
            if (ptr.next.info != null && ptr.next.info.getRollNo() == key) {
                tmp = ptr.next;
                ptr.next = tmp.next;
                return;
            }
            ptr = ptr.next;
        }
        System.out.print(key + " not found\n");
    }

    public void display() {
        int i;
        Record_Sep_Node ptr;
        for (i = 0; i < 10; i++) {
            if (table[i] != null) {
                ptr = table[i];
                while (ptr != null && ptr.info != null) {
                    System.out.println(ptr.info.getRollNo() + "  " + ptr.info.getName() + "   " + ptr.info.getAge());
                    ptr = ptr.next;
                }
            }
        }
        System.out.print("\n");
    }

    public void display_rec(int loc) {
        Record_Sep_Node ptr = table[loc];
        while (ptr != null && ptr.info != null) {
            System.out.println(ptr.info.getRollNo() + "  " + ptr.info.getName() + "   " + ptr.info.getAge());
            ptr = ptr.next;
        }
    }
}

public class HashSeperateChaining {
    public static void main(String[] args) {
        Student1 s;
        int roll, age;
        String name;
        Scanner sc = new Scanner(System.in);
        Hash_Seperate_Chaining hs = new Hash_Seperate_Chaining();

        hs.insert(new Student1(1, "Neha", 21));
        hs.insert(new Student1(2, "Savi", 22));
        hs.insert(new Student1(3, "Sanu", 23));
        hs.insert(new Student1(4, "Shinde", 24));

        hs.display();

        System.out.println("Search for key = " + hs.search(3));
        hs.display_rec(hs.search(3));

        hs.del(2);
        hs.display();

        hs.insert(new Student1(2, "Savi", 22));

        System.out.println("\n\n");
        hs.display();

    }
}
