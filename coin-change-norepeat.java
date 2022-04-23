import java.io.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.atomic.*;

//Assumes Distinct
class Result {
    static void unique_combinations(int l, int sum, Vector<Integer> A, Vector<Integer> local, int K, Vector<Vector<Integer>> ways, AtomicInteger waysn) {
        if(sum == K) {
            //Local has combo
            System.out.println(local);
            ways.add(local);
            waysn.set(waysn.get()+1);
        }

        for(int i = l; i < A.size(); i++) {
            //Do not process dupes
            if(i > 1 && A.get(i) == A.get(i - 1)) continue;
            //Skip combination that exceeds sum
            if(sum + A.get(i) > K) continue;
            //Add to combination
            local.add(A.get(i));
            unique_combinations(i + 1, sum + A.get(i), A, local, K, ways, waysn);
            local.remove(local.size() - 1);
        }
    }

    public static void getWaysToSum() {
        Integer[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        Vector<Integer> A = new Vector<>(Arrays.asList(arr)); 
        int K = 8;
        
        //Setup recursive call
        Collections.sort(A);
        Vector<Integer> local = new Vector<>();
        Vector<Vector<Integer>> ways = new Vector<>();
        AtomicInteger waysn = new AtomicInteger(0);

        unique_combinations(0, 0, A, local, K, ways, waysn);
        System.out.println(ways.size());
        System.out.println(waysn);
    }

    public static void tail(int n) {
        if(n == 1)
            return;
        else
            System.out.println(n);
        tail(n-1);
    }

    public static void head(int n) {
        if(n == 0)
            return;
        else
            head(n-1);
        System.out.println(n);
    }
}
