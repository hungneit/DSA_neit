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
    class Cost implements Comparable<Cost> {
        public int r,u,v;
        public Cost(int cost, int u, int v) {
            r = cost;
            this.u = u;
            this.v = v;
        }
        public int compareTo(Cost c) {
            if (r < c.r) return -1;
            if (r> c.r) return 1;
            if (v < c.v) return -1;
            if (v > c.v) return 1;
            return 0;
        }
    }
class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */
     public static int b[] = new int[1000];
     public static List<List<Cost>> lists = new ArrayList<>();
     public static PriorityQueue<Cost> pq = new PriorityQueue<>();
    
    public static void visit(int v) {
        b[v] = 1;
        for (Cost c : lists.get(v)) {
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
        while (!pq.isEmpty() && cnt < n - 1) {
            Cost c = pq.poll();
            if (b[c.u] == 1 && b[c.v] == 1) continue;
            sum += c.r;
            cnt++;
            if (b[c.u] == 0) {
                visit(c.u);
            }
            if (b[c.v] == 0) {
                visit(c.u);
            }
        }
        return sum;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
