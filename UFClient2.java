import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
//        In in = new In("tinyUF.txt"); // tạo luồng đọc từ file
//        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a helloooo
//        // xử lý dữ liệu trong mảng a
//        StdArrayIO.print(a); // in mảng ra màn hình
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int n = 0;
        boolean c = false;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            n++;
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            if(uf.count() == 1){
                c = true;
                StdOut.println(n);
                break;
            }
        }
        if(c == false) {
            StdOut.println("FAILED");
        }
    }
}
