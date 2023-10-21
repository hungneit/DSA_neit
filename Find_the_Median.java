public static void swap(List<Integer> arr, int i, int j) {
    int tmp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, tmp);
}
public static int partition(List<Integer> arr, int l, int r) {
    int i = l, j = r + 1;
    while (true) {
        while (arr.get(++i) < arr.get(l)) {
            if (i == r) break;
        }
        while (arr.get(--j) > arr.get(l)) {
            if (j == l) break;
        }
        if (i>=j) break;
        swap(arr, i, j);
    }
    swap(arr, l, j);
    return j;
}
public static int findMedian(List<Integer> arr) {
    int n = arr.size();
    int k = n/2;
    int l = 0, r = n - 1;
    while (l < r) {
        int p = partition(arr, l, r);
        if (p < k) l = p + 1;
        else if (p > k) r = p - 1;
        else return arr.get(k);
    }
    return arr.get(k);
}