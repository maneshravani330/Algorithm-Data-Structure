package data_structure5;

import java.util.Scanner;

public class Sequential_Search {

    public int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sequential_Search ss = new Sequential_Search();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        int result = ss.search(arr, key);

        if (result != -1) {
            System.out.println("Key found at index: " + result);
        } else {
            System.out.println("Key not found in the array.");
        }

    }
}
