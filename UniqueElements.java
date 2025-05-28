package data_structure;

public class UniqueElements {
    public static void main(String[] args) {
        int arr[] = {5, 12, 10, 2, 3, 8, -999};
        int cnt[] = new int[100]; 
        int i;
        boolean isUnique = true;

        for (i = 0; arr[i] != -999; i++) {
            cnt[arr[i]]++;
            if (cnt[arr[i]] > 1) {
                isUnique = false;
                break;
            }
        }

        if (isUnique) {
            System.out.println("All elements are unique.");
        } else {
            System.out.println("Array contains duplicate elements.");
        }
    }
}
