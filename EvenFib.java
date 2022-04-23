//https://www.hackerrank.com/contests/projecteuler/challenges/euler002/problem?isFullScreen=true

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static Long evenFibSum(Long n) {
        Long evenFib = 0L;
        Long fib = 1L;
        Long fib0 = 1L;
        Long fib1 = 1L;
        
        for(Long i = 2L; true; i++) {
            fib = fib0+fib1;
            fib0 = fib1;
            fib1 = fib;
            if(fib >= n) break;
            if(fib%2 == 0) evenFib += fib;
        }
        return evenFib;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(evenFibSum(n));
        }
    }
}