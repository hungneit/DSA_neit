public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    Map<Integer,Integer> mp1 = new HashMap<>();
    for (int i = 0; i< arr.size(); i++) {
        mp1.put(arr.get(i),mp1.getOrDefault(arr.get(i), 0)+1);
    }
    List<Integer> list = new ArrayList<>();
    Map<Integer,Integer> mp2 = new HashMap<>();
    for (int i = 0; i< brr.size(); i++) {
        mp2.put(brr.get(i),mp2.getOrDefault(brr.get(i), 0)+1);
    }
    Set<Integer> set = mp2.keySet();
    for (Integer key : set) {
        if (!mp1.containsKey(key)) {
            list.add(key);
        }
        else if (mp2.get(key) > mp1.get(key)) {
            list.add(key);
        }
    }
    Collections.sort(list);
    return list;
}