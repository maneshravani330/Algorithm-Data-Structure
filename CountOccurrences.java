package data_structure;

public class CountOccurrences {
    public static void main(String[] args) {
        int arr[] = {5, 12, 10, 2, 5, 3, 12, 10, 3, 3, -999};
        int cnt[] = new int[100]; 
        int i;
        
        for (i = 0; arr[i] != -999; i++) {
            cnt[arr[i]]++;
        }

        System.out.println("Element : Count");
        for (i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                System.out.println(i + " = " + cnt[i]);
            }
        }
    }
}
