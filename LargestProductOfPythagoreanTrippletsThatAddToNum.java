import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.concurrent.atomic.*;

public class Solution {
    public static int gcd(int a, int b) {
        int x = 0;
        int y = 0;
        int tmp;
        if(a < b) {
            x = b;
            y = a;
        } else {
            x = a;
            y = b;
        }
        
        while(x % y != 0) {
            tmp = x;
            x = y;
            y = tmp % x;
        }

        return y;         
    }
    
    public static int getPythagoreanTrippletProduct(int N) {
        int a=0, b=0, c=0;
        int s = N;
        int m = 0, k = 0, n = 0, d = 0;
        //boolean found = false;
        int max = -1;
        
        int mlimit = (int) Math.sqrt(s / 2);
        for (m = 2; m <= mlimit; m++) {
            if ((s / 2) % m == 0) { // m found
                if (m % 2 == 0) { // ensure that we find an odd number for k
                    k = m + 1;
                } else {
                    k = m + 2;
                }
                while (k < 2 * m && k <= s / (2 * m)) {
                    if (s / (2 * m) % k == 0 && gcd(k, m) == 1) {
                        d = s / 2 / (k * m);
                        n = k - m;
                        a = d*(m * m - n * n);
                        b = 2 * d * n * m;
                        c = d * (m * m + n * n);
                        //Would Stop on smallest triplet that are primitives
                        // meaning are coprimes
                        //found = true;
                        //break;
                        if(a+b+c == N) {
                            //System.out.printf("A %s, B %s, C %s\n",a,b,c);
                            //System.out.printf("Product %s\n",a,b,c);
                            max = Math.max(max, a*b*c);
                        }
                    }
                    k += 2;
                }
            }
            //Would Stop on smallest triplet that are coprimes
            //if (found) {
            //    break;
            //}
        }
        //System.out.printf("Max %s\n",a,b,c);
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(getPythagoreanTrippletProduct(n));
        }
    }
}