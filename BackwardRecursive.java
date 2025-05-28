package data_structure3;

public class BackwardRecursive {

    public static void main(String[] args) {
        fun(1);  // Starting from 1
    }

    static void fun(int n) {
        if (n > 5)
            return;
        fun(n + 1);             // Recursive call first
        System.out.println(n);  // Backward recursive: action after recursive call
    }
}

