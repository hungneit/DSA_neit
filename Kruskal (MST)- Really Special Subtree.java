import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Edge implements Comparable<Edge> {
        public int u, v, w;

        public Edge(int vertex1, int vertex2, int weight) {
            u = vertex1;
            v = vertex2;
            w = weight;
            if (u > v) {
                int tmp = u;
                u = v;
                v = tmp;
            }
        }

        public int compareTo(Edge o) {
            if (w < o.w) return -1;
            if (w > o.w) return 1;
            if (u < o.u) return -1;
            if (u > o.u) return 1;
            return Integer.compare(v, o.v);
        }
    }

    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int pp = find(p);
            int pq = find(q);
            if (pp != pq) {
                if (size[pp] > size[pq]) {
                    int tmp = pp;
                    pp = pq;
                    pq = tmp;
                }
                parent[pq] = pp;
                size[pp] += size[pq];
            }
        }

    public int find(int p) {
        if (p == parent[p]) return p;
        return parent[p] = find(parent[p]);
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
class Result {
    
    // private static int kruskals(int n, Queue<Edge> pq) {
    //     int minMst = 0;
    //     UnionFind unf = new UnionFind(n);
    //     for (int i = 1; i < n; i++) {
    //         Edge min = pq.poll();
    //         while (!pq.isEmpty() && unf.isConnected(min.u, min.v)) {
    //             min = pq.poll();
    //         }
    //         unf.union(min.u, min.v);
    //         minMst += min.w;
    //     }

    //     return minMst;
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();
    //     Queue<Edge> pq = new PriorityQueue<>();
    //     for (int i = 0; i < m; i++) {
    //         int u = sc.nextInt();
    //         int v = sc.nextInt();
    //         int w = sc.nextInt();
    //         Edge edge = new Edge(u, v, w);
    //         pq.add(edge);
    //     }
    //     System.out.println(kruskals(n, pq));

    //     sc.close();
    // }

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int m = gFrom.size();
        Queue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int u = gFrom.get(i);
            int v = gTo.get(i);
            int w = gWeight.get(i);
            Edge edge = new Edge(u, v, w);
            pq.add(edge);
        }
        int minMst = 0;
        UnionFind unf = new UnionFind(gNodes);
        for (int i = 1; i < gNodes; i++) {
            Edge min = pq.poll();
            while (!pq.isEmpty() && unf.isConnected(min.u, min.v)) {
                min = pq.poll();
            }
            unf.union(min.u, min.v);
            minMst += min.w;
        }
        return minMst;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.

        bufferedReader.close();
        bufferedWriter.close();
    }
}
