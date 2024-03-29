import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long squareOfSum(long n) {
        long sum = (n*(n+1L))/2L;
        return sum*sum;
    }
    
    public static long sumOfSquares(long n) {
        return (n*(n+1L)*(2L*n+1L))/6L;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(squareOfSum(n)-sumOfSquares(n));
        }
    }
}