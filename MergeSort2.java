package data_structure5;

import java.util.Scanner;

public class MergeSort2 {

    public void merge_ver2(int arr1[], int res[], int low1, int high1, int low2, int high2) {
        int i = low1, j = low2, tar = 0;

        while (i <= high1 && j <= high2) {
            if (arr1[i] < arr1[j]) {
                res[tar++] = arr1[i++];
            } else if (arr1[j] < arr1[i]) {
                res[tar++] = arr1[j++];
            } else {
                res[tar++] = arr1[i++];
                j++;
            }
        }

        while (i <= high1) {
            res[tar++] = arr1[i++];
        }

        while (j <= high2) {
            res[tar++] = arr1[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSort2 ms = new MergeSort2();

        System.out.print("Enter total number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter low1 and high1: ");
        int low1 = sc.nextInt();
        int high1 = sc.nextInt();

        System.out.print("Enter low2 and high2: ");
        int low2 = sc.nextInt();
        int high2 = sc.nextInt();

        int[] res = new int[(high1 - low1 + 1) + (high2 - low2 + 1)];

        ms.merge_ver2(arr, res, low1, high1, low2, high2);

        System.out.println("Merged result:");
        for (int num : res) {
            System.out.print(num + " ");
        }

    }
}

//Enter total number of elements: 6
//Enter 6 sorted elements:
//1 3 5 2 4 6
//Enter low1 and high1: 0 2
//Enter low2 and high2: 3 5

