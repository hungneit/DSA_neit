import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;



public class SelectionSort {
    public void Sort(Comparable[] a) {
        int m;
        for (int i = 0; i<a.length - 1; i++) {
            m = i;
            for (int j = i + 1; j < a.length; j++) {
                if(less(a[j], a[m]) == true) {
                    m = j;
                }
            }
            exch(a, i, m);
        }
    }

    public boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }
    public void exch(Comparable[] a, int i, int m) {
        Comparable t = a[i];
        a[i] = a[m];
        a[m] = t;
    }
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
    public static void main(String[] args) {

        SelectionSort s = new SelectionSort();
        String[] a = StdIn.readAllStrings();
        long start = System.currentTimeMillis();
        s.Sort(a);
        long end = System.currentTimeMillis();
        s.show(a);
        StdOut.println(end - start);
    }
}
