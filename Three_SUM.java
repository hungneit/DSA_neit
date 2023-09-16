import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Three_SUM {
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        Arrays.sort(a);
        int n= a.length;
        int i,j,k;
        for (i = 0; i < n; i++) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                if (a[i] + a[j] + a[k] == 0) {
                    StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    j++; k--;
                }
                if (a[i] + a[j] + a[k] < 0) {
                    j++;
                }
                if (a[i] + a[j] + a[k] > 0) {
                    k--;
                }
            }
        }
    }
}