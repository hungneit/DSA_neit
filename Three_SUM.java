import edu.princeton.cs.algs4.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[]a=StdIn.readAllInts();
        int n=a.length;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                for (int k=j+1;k<n;k++){
                    if (a[i]+a[j]+a[k]==0){
                        StdOut.print(a[i]+" "+a[j]+" "+a[k]);
                    }
                }
            }
        }
    }
}
