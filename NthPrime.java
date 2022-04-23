import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Sieve of Eratosthenes
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ArrayList<Integer> primes;
        int k = Integer.MAX_VALUE - 2;
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            primes = new ArrayList<Integer>(Arrays.asList(new Integer[]{2, 3}));
            if(n == 1 || n == 2) {
                System.out.println(n);
                continue;
            }
            for(int i = 5; i <= k; i += 2) {
                int sqrt = (int) Math.sqrt(i);
                boolean is_prime = true;
                //You only have to check that primes less than the square-root of a number
                // divide it. If they do it is not a prime, or else it is.
                //Every number has atleast 1 prime factor
                for(int j = 0; j < primes.size() && primes.get(j) <= sqrt; j++) {
                    if(i % primes.get(j) == 0) {
                        is_prime = false;
                        break;
                    }
                }
                if(is_prime) {
                    primes.add(i);
                    if(primes.size() == n) {
                        System.out.println(i);
                        break;
                    }
                }
            }
            
        }
    }
}