package data_structure;

public class OnlyDuplicates {
    public static void main(String[] args) {
        int arr[] = {5, 12, 10, 2, 5, 3, 12, 10, -999};
        int cnt[] = new int[24]; 
        int i;
        for (i = 0; arr[i] != -999; i++) {
            cnt[arr[i]]++;
        }

        System.out.println("Duplicate");
        for (i = 0; i < cnt.length; i++) {
            if (cnt[i] > 1) {
                System.out.print(i + " ");
            }
        }
    }
}
