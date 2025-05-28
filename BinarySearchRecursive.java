package exam;

import java.util.Scanner;

public class BinarySearchRecursive {
    // Recursive binary search function
    public int binary_search_recursive(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;
        else if (key < arr[mid])
            return binary_search_recursive(arr, low, mid - 1, key);
        else
            return binary_search_recursive(arr, mid + 1, high, key);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchRecursive bs = new BinarySearchRecursive();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        int result = bs.binary_search_recursive(arr, 0, n - 1, key);

        if (result != -1) {
            System.out.println("Key found at index: " + result);
        } else {
            System.out.println("Key not found in the array.");
        }

    }
}

