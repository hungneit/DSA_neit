public static List<Integer> countingSort(List<Integer> arr) {
    List<Integer> list = new ArrayList<>();
    list.addAll(Collections.nCopies(100, 0));
    for (int x:arr) {
        list.set(x, list.get(x) + 1);
    }
    return list;
}