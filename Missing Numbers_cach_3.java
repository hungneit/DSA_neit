public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        int a[] = new int[10000];
        int b[] = new int[10000];
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            a[arr.get(i)]++;
        }
        for (int i = 0; i < brr.size(); i++) {
            b[brr.get(i)]++;
        }
        for (int i = 0; i < brr.size(); i++) {
            if (b[brr.get(i)]>a[brr.get(i)]&& !result.contains(brr.get(i))) {
                result.add(brr.get(i));
            }
        }
        Collections.sort(result);
        return result;

    }
