public static List<Integer> merge(List<Integer> l, List<Integer> r) {
    List<Integer> result = new ArrayList<>();
    int i =0, j =0;
    while (i < l.size() && j < r.size()) {
        if (l.get(i) <= r.get(j)) {
            result.add(l.get(i));
            i++;
        }
        else {
            result.add(r.get(j));
            j++;
        }
    }
    while (i < l.size()) {
        result.add(l.get(i));
        i++;
    }
    while (j < r.size()) {
        result.add(r.get(j));
        j++;
    }
    return result;
}

public static List<Integer> mergesort(List<Integer> list) {
    if (list.size() <= 1) {
        return list;
    }
    int sz = list.size();
    int mid = sz/2;
    List<Integer> l = new ArrayList<>(); 
    List<Integer> r = new ArrayList<>();
    for ( int i = 0; i < mid; i++) {
        l.add(list.get(i));
    }
    for ( int i = mid; i < list.size(); i++) {
        r.add(list.get(i));
    }
    
    l = mergesort(l);
    r = mergesort(r);
    
    return merge(l, r);
}

public static List<Integer> closestNumbers(List<Integer> arr) {
    arr = mergesort(arr);
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
