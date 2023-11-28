import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        int[] a = new int[1000];
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sn.nextInt();
            mp.put(a[i], mp.getOrDefault(a[i],0) + 1);
        }
        int target = sn.nextInt();
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(target - a[i])) {
                if (target == 2*a[i] && mp.get(a[i]) >= 2){
                    System.out.println("["+ a[i] + ", " + (target - a[i]) + "]");
                } else if(target != 2*a[i] && a[i] < target - a[i]) {
                    System.out.println("["+ a[i] + ", " + (target - a[i]) + "]");
                }
            }
        }
    }
}
