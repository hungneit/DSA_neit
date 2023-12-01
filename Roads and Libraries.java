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

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */
    
    // public static int dis[] = new int[10000];
    public static int x;
    public static void dfs(Map<Integer,List<Integer>> mp, int u, int n, int b[]) {
        b[u] = 1;
        x++;
        if (mp.containsKey(u)){
            for (int i : mp.get(u)) {
            if (b[i] == 0) {
                dfs(mp, i, n, b);
            }
        }
        }
        
    }
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        if (c_lib < c_road) {
            return (long)n * (long)c_lib;
        }
        // int a[][] = new int[1000][1000];
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < cities.size(); i++) {
            if (!mp.containsKey(cities.get(i).get(0))) {
                mp.put(cities.get(i).get(0),new ArrayList<Integer>());
            }
            if (!mp.containsKey(cities.get(i).get(1))) {
                mp.put(cities.get(i).get(1),new ArrayList<Integer>());
            }
            mp.get(cities.get(i).get(0)).add(cities.get(i).get(1));
            mp.get(cities.get(i).get(1)).add(cities.get(i).get(0));
        }
        // for (int i = 1; i <= n; i++) {
        //     b[i] = 1;
        // }
        int b[] = new int[100000];
        x = 0;
        long cost = 0;
        for (int i = 1; i <= n; i++) {
            if (b[i] == 0) {
                dfs(mp, i, n, b);
                cost += (long)(x-1)*(long)c_road + (long)c_lib;
                x = 0;
            }
        }
        return cost;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
