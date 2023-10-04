import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<String> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (k == 1) {
                st.push(s);
                String t = sc.next();
                s += t;
            }
            else if (k == 2) {
                st.push(s);
                int x = sc.nextInt();
                s = s.substring(0, s.length() - x);
            }
            else if (k == 3) {
                int x = sc.nextInt();
                System.out.println(s.charAt(x - 1));
            }
            else if (k == 4) {
                if (!st.empty()) {
                    s = st.pop();
                }
            }
        }
    }
}
