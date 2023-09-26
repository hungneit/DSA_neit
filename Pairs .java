public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) + k > arr.get(arr.size() - 1)) {
                    break;
            }
            int l = i + 1, r = arr.size() - 1;
            while (l <= r) {
                int m= (l + r) / 2;
                if (arr.get(m) == arr.get(i) + k) {
                   count++;
                   break;
                }
                else if (arr.get(m) > arr.get(i) + k) {
                   r = m - 1;
                }
                else {
                   l = m + 1;
                }
            }
        }
        return count;
    }