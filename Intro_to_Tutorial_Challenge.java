public static int introTutorial(int V, List<Integer> arr) {
    int l = 0, r = arr.size() - 1;

    while (l <= r) {
        int mid = (l + r) / 2;
        if (arr.get(mid) == V) {
            return mid;
        }
        if (arr.get(mid) < V) {
            l = mid + 1;
        }
        if (arr.get(mid) > V) {
            r = mid - 1;
        }
    }
    return -1;
}