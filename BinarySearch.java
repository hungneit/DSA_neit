import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BinarySearch {
    public static int binarySearch(int[] a, int number) {
        Arrays.sort(a);
        int l = 0, r = a.length;
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
        StdOut.print(binarySearch(a, 7));
    }
}