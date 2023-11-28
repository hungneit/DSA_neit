import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class B1 {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        int[] a = new int[1000];
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(-1,0);
        int s =0;
        for (int i = 0; i < n; i++) {
            a[i] = sn.nextInt();
            s+=a[i];
            mp.put(i, s);
        }

    }
}