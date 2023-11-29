public static int b[] = new int[1000];
    public static int dis[] = new int[10000];
    public static void find(int u, int n, int a[][]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        b[u] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 1; i <= n; i++) {
                if (a[v][i] == 1 && b[i] == 1) {
                    b[i] = 0;
                    q.add(i);
                    dis[i] = dis[v] + 6;
                }
            }
        }
    }
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        int a[][] = new int[1000][1000];
        for (int i = 0; i < edges.size(); i++) {
            a[edges.get(i).get(0)][edges.get(i).get(1)] = 1;
            a[edges.get(i).get(1)][edges.get(i).get(0)] = 1;
        }
        for (int i = 1; i <= n; i++) {
            b[i] = 1;
            dis[i] = 0;
        }
        List<Integer> list = new ArrayList<>();
        find(s, n, a);
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                if (dis[i] == 0) {
                    list.add(-1);
                }
                else list.add(dis[i]);
            }
        }
        return list;
    }