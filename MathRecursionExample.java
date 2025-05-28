package data_structure3;

public class MathRecursionExample {

    public static void main(String[] args) {
        int num = 1234;

        System.out.println("Count of digits in " + num + " = " + cnt(num));
        System.out.println("Sum of digits in " + num + " = " + sum_of_digit(num));
        System.out.print("Digits in reverse order: ");
        displayR(num);
        System.out.println("\nPower = " + power(2, 4));
    }

    public static int cnt(int n) {
        if (n / 10 == 0)
            return 1;
        return 1 + cnt(n / 10);
    }

    public static int sum_of_digit(int n) {
        if (n / 10 == 0)
            return n;
        return n % 10 + sum_of_digit(n / 10);
    }

    public static void displayR(int n) {
        if (n / 10 == 0) {
            System.out.println(n);
            return;
        }
        System.out.print(n % 10 + " ");
        displayR(n / 10);
    }

    public static int power(int a, int p) {
        if (p == 0)
            return 1;
        return a * power(a, p - 1);
    }
}

