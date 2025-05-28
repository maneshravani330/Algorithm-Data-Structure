package data_structure6;

public class MaxHeapif{
    public static void maxHeapify(int[] B, int s, int n) {
        int left = 2 * s + 1;     
        int right = 2 * s + 2;    
        int largest = s;

        if (left < n && B[left] > B[largest]) {
            largest = left;
        }

        if (right < n && B[right] > B[largest]) {
            largest = right;
        }

        if (largest != s) {
            // Swap
            int temp = B[s];
            B[s] = B[largest];
            B[largest] = temp;          
            maxHeapify(B, largest, n);
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 1, 4, 5};
        int n = arr.length;

        maxHeapify(arr, 0, n);
        System.out.println("After Max-Heapify:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
