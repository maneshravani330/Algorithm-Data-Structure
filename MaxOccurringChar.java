package data_structure;

public class MaxOccurringChar {
    public static void main(String[] args) {
        String str = "immitent";
        int freq[] = new int[256]; 
        int i, max = 0;

        for (i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
            }
        }

        System.out.println("Characters with maximum occurrence:");
        for (i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch] == max) {
                System.out.print(ch + " ");
                freq[ch] = 0; 
            }
        }
    }
}
