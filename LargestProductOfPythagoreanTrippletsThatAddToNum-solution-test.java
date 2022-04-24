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
                            System.out.printf("A %s, B %s, C %s\n",a,b,c);
                            System.out.printf("Product %s\n",a*b*c);
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
        System.out.printf("Max %s\n",max);
        return max;
    }

    static void unique_combinations(int l, int sum, Vector<Integer> local, int K, AtomicInteger max) {
        if(sum == K && local.size() == 3) {
            //Local has combo
            if(isPythagoreanTriplet(local)) {
                System.out.println(local);
                max.set( Math.max( max.get(), product(local) ) );
            }
        } else if(local.size() == 3) {
            return;
        }

        for(int i = l; i < K; i++) {
            //Skip combination that exceeds sum
            if(sum + i > K) break;
            //Add to combination
            local.add(i);
            unique_combinations(i + 1, sum + i, local, K, max);
            local.remove(local.size() - 1);
        }
    }
    
    public static boolean isPythagoreanTriplet(Vector<Integer> way) {
        int a = way.get(0);
        int b = way.get(1);
        int c = way.get(2);
        return (int)Math.pow(a, 2) + (int)Math.pow(b, 2) == (int)Math.pow(c, 2);
    }
    
    public static int product(Vector<Integer> components) {
        int product = 1;
        for(int component : components) {
            product *= component;
        }
        return product;
    }

    public static void main(String[] args) {
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            System.out.printf("Number %s\n", i);
            Vector<Integer> local = new Vector<>();
            AtomicInteger max = new AtomicInteger(-1);
            System.out.println("unique_combinations");
            unique_combinations(1, 0, local, i, max);
            System.out.println("getPythagoreanTrippletProduct");
            int max2 = getPythagoreanTrippletProduct(i);
            System.out.printf("Max1 %s Max2 %s\n", max.get(), max2);
            if(max.get() != max2) {
                System.out.println("Mismatch!");
                break;
            }
        }
    }
}