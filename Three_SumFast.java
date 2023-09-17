import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class ThreeSum {
    public static int binarySearch(int[] a, int number) {
        Arrays.sort(a);
        int l = 0, r = a.length - 1 ;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == number) {
                return m;
            }
            if (a[m] > number) {
                r = m;
            }
            if (a[m] < number) {
                l = m;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        int n = a.length;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                int x = binarySearch(a,-1 * (a[i] + a[j]));
                if (x != -1) {
                    StdOut.println(a[i] + " " + a[j] + " " + a[x]);
                }
            }
        }
    }
}
