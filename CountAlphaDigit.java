package data_structure;

public class CountAlphaDigit {
    public static void main(String[] args) {
        String str = "infoway 123tech   34Pt67 .po";
        int cnt[] = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                cnt[ch]++;
            }
        }

        System.out.println("Alphabet occurrences:");
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (cnt[ch] > 0) {
                System.out.println(ch + " : " + cnt[ch]);
            }
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (cnt[ch] > 0) {
                System.out.println(ch + " : " + cnt[ch]);
            }
        }
        
        System.out.println("\nDigit occurrences:");
        for (char ch = '0'; ch <= '9'; ch++) {
            if (cnt[ch] > 0) {
                System.out.println(ch + " : " + cnt[ch]);
            }
        }
    }
}
