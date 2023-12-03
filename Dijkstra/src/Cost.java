class Cost implements Comparable<Cost> {
    public int r,u,v;
    public Cost(int cost, int v) {
        r = cost;
        this.v = v;
    }
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r> c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return +1;
        return 0;
    }
}
