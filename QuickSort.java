package exam;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p= arr[high];
            int i = low;
            for (int j = low; j < high; j++) {
                if (arr[j] < p) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                }
            }
            int temp = arr[i];
            arr[i] = arr[high];
            arr[high] = temp;
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3};
        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
