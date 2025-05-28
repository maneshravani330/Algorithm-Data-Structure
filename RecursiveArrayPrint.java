package data_structure3;

public class RecursiveArrayPrint {

    // Recursive function to print array forward and backward
    static void printArray(int[] arr, int index) {
        // Base case: if index reaches array length, start reverse printing
        if (index == arr.length) {
            return;
        }

        // Print in forward order
        System.out.print(arr[index] + " ");

        // Recursive call
        printArray(arr, index + 1);

        // Print in reverse order during backtracking
        System.out.print(arr[index] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println("Forward and Reverse order using recursion:");
        printArray(arr, 0);
    }
}

