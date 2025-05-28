package data_structure3;

public class ReverseArrayDisplay {

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        display(arr, 0);
    }

    static void display(int a[], int i) {
        if (i > 9)
            return;
        display(a, i + 1);             // Recursive call first
        System.out.println(a[i]);      // Backward recursion: prints in reverse order
    }
}

