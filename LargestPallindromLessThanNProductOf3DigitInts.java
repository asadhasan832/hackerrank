import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//A pallindrome is a multiple of 11

public class Solution {
    public static boolean isPallindrome(int p) {
        String ps = Integer.toString(p);
        StringBuilder pt = new StringBuilder(ps);
        StringBuilder pr = pt.reverse();
        return pr.toString().equals(ps);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int lastP = 0;
            int product = 0;
            for(int x = 100; x <= 999; x++) {
                //Only iterate multiples of 11, or all if x is a multiple or 11
                for(int y = 110; y <= 999; y += (x%11 == 0) ? 1 : 11) {
                    product = x*y;
                    if(product < n && isPallindrome(product)) {
                        lastP = Math.max(lastP, product);
                    }
                }    
            }
            System.out.println(lastP);
        }
    }
}