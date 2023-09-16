import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Two_SUM {
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        int n=a.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(a[i] + a[j] == 0) {
                    StdOut.println(a[i] + " " + a[j]);
                }
            }
        }
    }
}