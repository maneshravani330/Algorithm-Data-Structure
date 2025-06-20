package data_structure3;

public class ArraySum {

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.println("Sum = " + sum(arr, 0));
    }

    static int sum(int[] a, int i) {
        if (i > 9)
            return 0;
        System.out.println(a[i]);  // Optional: shows elements being added
        return a[i] + sum(a, i + 1);
    }
}

