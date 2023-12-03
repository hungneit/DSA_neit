import java.util.*;

class Hello {

    public static int b[] = new int[100000];
    public static int distTo[] = new int[100000];
    public static List<List<Cost>> lists = new ArrayList<>();
    public static PriorityQueue<Cost> pq = new PriorityQueue<>();
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        lists.clear();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            lists.get(edges.get(i).get(0)).add(new Cost(edges.get(i).get(2), edges.get(i).get(1)));
            lists.get(edges.get(i).get(1)).add(new Cost(edges.get(i).get(2), edges.get(i).get(0)));
        }
        for (int i = 1; i <= n; i++) {
            b[i] = 0;
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[s] = 0;
        pq.add(new Cost(0, s));
        while(!pq.isEmpty()) {
            Cost c = pq.poll();
            b[c.v] = 1;
            for (Cost x : lists.get(c.v)) {
                if (distTo[x.v] > distTo[c.v] + x.r) {
                    distTo[x.v] = distTo[c.v] + x.r;
                    pq.add(new Cost(x.r, x.v));
                }
            }
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i<=n; i++) {
            if (i != s) {
                if (distTo[i] < Integer.MAX_VALUE) {
                    l.add(distTo[i]);
                }
                else l.add(-1);
            }
        }
        return l;
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
        int t = sn.nextInt();
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
        System.out.println(shortestReach(n, e, start));


//        int x = 100,s = 0;
//        for (int i = 1; i < 1000; i++) {
//            s += x;
//            x += 100;
//        }
//        System.out.println(s);
    }

}
