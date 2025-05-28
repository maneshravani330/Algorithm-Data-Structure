package data_structure5;

import java.util.Scanner;

public class MergeSort3 {

    public void copy(int[] arr, int[] temp, int low, int high) {
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }

    public void merge_ver2(int[] arr1, int[] res, int low1, int high1, int low2, int high2) {
        int i = low1, j = low2, tar = low1;

        while (i <= high1 && j <= high2) {
            if (arr1[i] < arr1[j]) {
                res[tar++] = arr1[i++];
            } else {
                res[tar++] = arr1[j++];
            }
        }

        while (i <= high1) {
            res[tar++] = arr1[i++];
        }

        while (j <= high2) {
            res[tar++] = arr1[j++];
        }
    }

    public void merge_sort(int[] arr, int low, int high) {
        int mid;
        int[] temp = new int[arr.length];

        if (low < high) {
            mid = (low + high) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid + 1, high);
            merge_ver2(arr, temp, low, mid, mid + 1, high);
            copy(arr, temp, low, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSort3 ms = new MergeSort3();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ms.merge_sort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
