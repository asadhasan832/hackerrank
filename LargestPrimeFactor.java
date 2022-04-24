import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static Long getLargestPrimeFactor(Long n) {
        Stack<Long> primeFactors = new Stack<>();
        while(n%2L == 0L) {
            primeFactors.push(2L);
            n /= 2L;
        }
        for(Long i = 3L; i <= Math.sqrt(n); i += 2) {
            while(n % i == 0) {
                primeFactors.push(n);
                n /= i;
            }
        }
        if(n > 2) {
            primeFactors.push(n);
        }
        
        return primeFactors.pop();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(getLargestPrimeFactor(n));
        }
    }
}
