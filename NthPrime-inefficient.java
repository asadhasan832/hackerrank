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
        ArrayList<Long> primes;
        long k = Long.MAX_VALUE - 2L;
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            primes = new ArrayList<Long>(Arrays.asList(new Long[]{2L, 3L}));
            if(n == 1L || n == 2L) {
                System.out.println(primes.get(n-1));
                continue;
            }
            for(long i = 5; i <= k; i += 2) {
                long sqrt = (long) Math.sqrt(i);
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