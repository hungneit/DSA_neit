public static List<Integer> quickSort(List<Integer> arr) {
    int pivot = arr.get(0);
    int i = 0, j = arr.size();
    while (true) {
        while (arr.get(++i) < pivot) {
            if (i == arr.size() - 1) break;
        }
        while (arr.get(--j) > pivot) {
            if (j == 0) break;
        }
        if (i >= j) break;
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
    arr.set(0, arr.get(j));
    arr.set(j, pivot);
    return arr;
}