import java.io.*;
import java.util.*;

public class Solution {
    public static void swap(int[] a,int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static int partition(int[] a, int l, int r,int n) {
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (a[j] <= a[r]) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        for ( int x = 0; x < n; x++) {
            System.out.print(a[x] + " ");
        }
        System.out.println("");
        return i + 1;
    }
    public static void sort(int[] a, int l, int r,int n) {
        if (l>=r) return;
        int p = partition(a, l, r,n);
        sort(a, l, p-1,n);
        sort(a, p+1, r,n);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int[] a = new int[n];
        for(int i =0;i<n;i++) {
            a[i] = sn.nextInt();
        }
        sort(a, 0, n-1,n);
    }
}
