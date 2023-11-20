public static int cookies(int k, List<Integer> A) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(A);
    // if (pq.poll() >= k || pq.size()<2) return -1;
    int cnt = 0;
    while (pq.peek() < k && pq.size()>=2) {
        cnt++;
        pq.add(pq.poll() + 2 * pq.poll());
    }
    if (pq.peek() >= k) {
        return cnt;
    }
    return -1;
}