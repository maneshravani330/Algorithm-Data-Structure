package data_structure3;

public class ForwardRecursion {

    public static void main(String[] args) {
        fun(1);  // Starting from 1
    }

    static void fun(int n) {
        if (n > 5)
            return;
        System.out.println(n);  // Forward recursive: action before recursive call
        fun(n + 1);
    }
}

