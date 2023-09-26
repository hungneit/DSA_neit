public static List<Integer> closestNumbers(List<Integer> arr) {
    Collections.sort(arr);
    int x = Integer.MAX_VALUE;
    for (int i = 1; i < arr.size(); i++) {
        if(arr.get(i) - arr.get(i - 1) < x) {
            x = arr.get(i) - arr.get(i - 1);
        }
    }
    List<Integer> a = new ArrayList<Integer>();
    for (int i = 1; i < arr.size(); i++) {
        if(arr.get(i) - arr.get(i - 1) == x) {
            a.add(arr.get(i - 1));
            a.add(arr.get(i));
        }
    }
    return a;
}