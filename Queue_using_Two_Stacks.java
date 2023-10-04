import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (k == 1) {
                int x = sc.nextInt();
                a.push(x);
            }
            else {
                if (b.empty()) {
                    while (!a.empty()) {
                        b.push(a.pop());
                    }
                }
                if (k == 2) {
                    b.pop();
                }
                if (k == 3) {
                    System.out.println(b.peek());
                }
            }
        }
    }
} 
