public static List<Double> runningMedian(List<Integer> a) {
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    List<Double> l = new ArrayList<>();
    int n = a.size();
    for (int i =0; i < n; i++) {
        if (maxPQ.size() <= minPQ.size()) {
            maxPQ.add(a.get(i));
        }
        else {
            minPQ.add(a.get(i));
        }
        if (!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
            int tmp = maxPQ.poll();
            maxPQ.add(minPQ.poll());
            minPQ.add(tmp);
        }
        if (maxPQ.size() == minPQ.size()) {
            l.add((double)(maxPQ.peek() + minPQ.peek())/2);
        }
        else {
            l.add((double)maxPQ.peek());
        }
    }
    return l;
}