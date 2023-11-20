public class MergeSort {
    public static int[] merge(int[] l, int[] r) {
        int[] a = new int[l.length + r.length];
        int i = 0, j = 0, k = 0;

        while (i < l.length && j < l.length) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                i++;
                k++;
            }
            else {
                a[k] = r[j];
                j++;
                k++;
            }
        }

        while (i < l.length) {
            a[k] = l[i];
            i++;
            k++;
        }
        while (j < r.length) {
            a[k] = r[j];
            j++;
            k++;
        }

        return a;
    }
    public static int[] mergesort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int mid = a.length / 2;
        int[] l = new int[mid];
        int[] r = new int[a.length - mid];

        for (int i =0; i<mid; i++) {
            l[i] = a[i];
        }
        for (int i =mid; i<a.length; i++) {
            r[i-mid] = a[i];
        }
        l = mergesort(l);
        r = mergesort(r);
        a = merge(l,r);
        return a;
    }

    public static void main(String[] args) {
        int[] a = {3,9,6, 10, 1, 36,32};
        a = mergesort(a);
        for (int x: a) {
            System.out.println(x);
        }
    }
}
