static int cnt = 0;
    static int a[][] = new int[100][100];
    public static void dfs(int i, int j,int n, int m) {
        a[i][j] = 0;
        cnt++;
        if (j+1 < m && a[i][j+1] == 1) {
            dfs(i, j+1, n, m);
        }
        if (j-1 >=0 && a[i][j-1] == 1 ) {
            dfs(i, j-1, n, m);
        }
        if (i+1 < n && a[i+1][j] == 1) {
            dfs(i+1, j, n, m);
        }
        if (i-1 >= 0 && a[i-1][j] == 1) {
            dfs(i-1, j, n, m);
        }
        if (i+1 < n && j+1 < m && a[i+1][j+1] == 1) {

            dfs(i+1, j+1, n, m);
        }
        if (i-1 >= 0 && j-1 >=0 && a[i-1][j-1] == 1) {
            dfs(i-1, j-1, n, m);
        }
        if (i-1 >= 0 && j+1 < m &&a[i-1][j+1] == 1 ) {
            dfs(i-1, j+1, n, m);
        }
        if (i+1 < n && j-1 >=0 && a[i+1][j-1] == 1) {
            dfs(i+1, j-1, n, m);
        }
    }
    public static int connectedCell(List<List<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        for (int i = 0; i < n; i++) {
            for(int j =0 ; j < m; j++) {
                if (matrix.get(i).get(j) == 1)
                a[i][j] = 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for(int j =0 ; j < m; j++) {
                if (a[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j, n, m);
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;
    }