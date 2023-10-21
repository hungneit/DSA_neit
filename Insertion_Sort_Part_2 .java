public static void insertionSort2(int n, List<Integer> arr) {
    for (int i = 1; i < n; i++) {
        int tmp = arr.get(i);
        int j = i - 1;
        while (j >= 0 && arr.get(j) > tmp) {
            arr.set(j + 1, arr.get(j));
            j--;
        }
        arr.set(j+1, tmp);
        for (int k = 0;k < n; k++) {
                System.out.print(arr.get(k) + " ");
                
            }
            System.out.println("");
    }

}