import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.concurrent.atomic.*;

public class Solution {
    static void unique_combinations(int l, int sum, Vector<Integer> local, int K, AtomicInteger max) {
        if(sum == K && local.size() == 3) {
            //Local has combo
            if(isPythagoreanTriplet(local)) {
                //System.out.println(local);
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
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            Vector<Integer> local = new Vector<>();
            AtomicInteger max = new AtomicInteger(-1);
            unique_combinations(1, 0, local, n, max);
            System.out.println(max.get());
        }
    }
}