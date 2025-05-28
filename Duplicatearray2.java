package data_structure;

public class Duplicatearray2 {
    public static void main(String[] args) {
        int arr[] = {3, 12, 23, 5, 13, 12, 23, 7, -999};
        int tar[] = new int[arr.length]; 
        int tar_index = 0;
        
        tar[0] = arr[0]; 
        tar_index = 0;
        int i,j;
        for (i = 1; arr[i] != -999; i++) {
            for ( j = 0; j <= tar_index; j++) {
                if (arr[i] == tar[j]) {
                    break; 
                }
            }
            if (j > tar_index) {
                tar_index++; 
                tar[tar_index] = arr[i];
            }
        }
        for (i = 0; i <= tar_index; i++) {
            System.out.print(tar[i] + " ");
        }
    }
}

