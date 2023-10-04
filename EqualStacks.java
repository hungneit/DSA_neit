public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;
    for (int x:h1) {
        sum1 += x;
    }
    for (int x:h2) {
        sum2 += x;
    }
    for (int x:h3) {
        sum3 += x;
    }
    int i=0, j=0, k=0;
    int min = Math.min(Math.min(sum1, sum2), sum3);
    while (sum1 != sum2 || sum1 != sum3) {
        while (sum1 > min) {
            sum1 -= h1.get(i);
            i++;
        }
        while (sum2 > min) {
            sum2 -= h2.get(j);
            j++;
        }
        while (sum3 > min) {
            sum3 -= h3.get(k);
            k++;
        }
        min = Math.min(Math.min(sum1, sum2), sum3);
    }
    return sum1;
}