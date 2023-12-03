import java.util.*;

class Hello {

    public static int b[] = new int[100000];
    public static List<List<Cost>> lists = new ArrayList<>();
    public static PriorityQueue<Cost> pq = new PriorityQueue<>();

    public static void visit(int u) {
        b[u] = 1;
        for (Cost c : lists.get(u)) {
            if (b[c.v] == 0) {
                pq.add(c);
            }
        }
    }

    public static int prims(int n, List<List<Integer>> edges, int start) {

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            lists.get(edges.get(i).get(0)).add(new Cost(edges.get(i).get(2),edges.get(i).get(0), edges.get(i).get(1)));
            lists.get(edges.get(i).get(1)).add(new Cost(edges.get(i).get(2), edges.get(i).get(1), edges.get(i).get(0)));
        }
        visit(start);
        int sum = 0;
        int cnt =0;
        while (!pq.isEmpty() && cnt < n) {
            Cost c = pq.poll();
            if (b[c.u] == 1 && b[c.v] == 1) continue;
            sum += c.r;
            cnt++;
            if (b[c.u] == 0) {
                visit(c.u);
            }
            if (b[c.v] == 0) {
                visit(c.v);
            }
        }
        return sum;

    }
    public static void main(String[] args) {
//        Cost c1 = new Cost(3, 1, 2);
//        Cost c2 = new Cost(10, 2, 2);
//        Cost c3 = new Cost(6, 3, 2);
//        PriorityQueue<Cost> p = new PriorityQueue<>();
//        p.add(c1);
//        p.add(c2);
//        p.add(c3);
//        System.out.println(p.peek().r);


        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt(), m = sn.nextInt();
        List<List<Integer>> e = new ArrayList<>();
        for (int i =0; i < m; i++) {
            int x1 = sn.nextInt();
            int x2 = sn.nextInt();
            int x3 = sn.nextInt();
            List<Integer> x = new ArrayList<>();
            x.add(x1);
            x.add(x2);
            x.add(x3);
            e.add(x);
        }
        int start = sn.nextInt();
        System.out.println(prims(n, e, start));


//        int x = 100,s = 0;
//        for (int i = 1; i < 1000; i++) {
//            s += x;
//            x += 100;
//        }
//        System.out.println(s);
    }

}
