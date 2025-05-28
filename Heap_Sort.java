package data_structure6;

public class Heap_Sort {

    // Function to maintain the max-heap property
    public static void heapify(int arr[], int n, int i) {
        int largest = i;           // Initialize largest as root
        int left = 2 * i + 1;      // left child index
        int right = 2 * i + 2;     // right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            // Swap
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main function to perform heap sort
    public static void HeapSort(int arr[]) {
        int n = arr.length;

        // Build max heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Main method to test the heap sort
    public static void main(String[] args) {
        int arr[] = {48, 34, 67, 89, 12, 333, 44, 32, 2, 89, 78, 90};

        System.out.println("Original Array:");
        for (int i : arr) 
        	System.out.print(i + " ");
        System.out.println();

        HeapSort(arr);

        System.out.println("Sorted Array:");
        for (int i : arr)
        	System.out.print(i + " ");
    }
}
