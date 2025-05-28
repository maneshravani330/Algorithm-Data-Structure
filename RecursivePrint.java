package data_structure3;
public class RecursivePrint {

    // Recursive function to print numbers from 1 to 5
    public static void fun(int n) {
        if (n > 5)  // Base condition to stop recursion
            return;

        System.out.print(" " + n);  // Forward recursive print
        fun(n + 1);  // Recursive call with incremented n
    }

    public static void main(String[] args) {
        fun(1);  // Initial call with 1
    }
}

