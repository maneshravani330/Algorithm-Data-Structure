package data_structure5;

import java.util.Scanner;
public class MergeSort1 {

    public void merge_ver1(int arr1[], int arr2[], int res[]) {
        int i = 0, j = 0, tar = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[tar++] = arr1[i++];
            } else if (arr2[j] < arr1[i]) {
                res[tar++] = arr2[j++];
            } else {
                res[tar++] = arr1[i++];
                j++;
            }
        }

        while (i < arr1.length) {
            res[tar++] = arr1[i++];
        }

        while (j < arr2.length) {
            res[tar++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSort1 ms = new MergeSort1();

        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter " + n1 + " sorted elements:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter " + n2 + " sorted elements:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] res = new int[n1 + n2];
        ms.merge_ver1(arr1, arr2, res);

        System.out.println("Merged sorted array:");
        for (int num : res) {
            System.out.print(num + " ");
        }

    }
}
