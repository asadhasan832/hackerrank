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
    public static boolean baseCompnentsMakeUpSquareSum(int start, long squareSum, Vector<Integer> baseComponents, long targetSum, int item_cnt) {
        for(int i = start; i < baseComponents.size(); i++) {
            item_cnt++;
            squareSum += (long)Math.pow(baseComponents.get(i), 2);
            if(squareSum == targetSum && item_cnt > 1) {
                return true;
            }
            if(squareSum > targetSum) {
                return false;
            }
        }
        
        return false;
    }
    
    public static boolean hasConsecutiveBaseSquareSum(int n, int step) {
        Vector<Integer> baseComponets = new Vector<>();
        for(int i = 1; i <= Math.sqrt(n); i += step) {
            baseComponets.add(i);
        }

        for(int i = 0; i < baseComponets.size(); i++) {
            if(baseCompnentsMakeUpSquareSum(i, 0, baseComponets, n, 0)) return true;
        }
        
        Vector<Integer> baseComponets2 = new Vector<>();
        for(int i = 2; i <= Math.sqrt(n); i += step) {
            baseComponets2.add(i);
        }

        for(int i = 0; i < baseComponets2.size(); i++) {
            if(baseCompnentsMakeUpSquareSum(i, 0, baseComponets2, n, 0)) return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int d = in.nextInt();
            int sum = 0;
            
            for(int x = 1; x < n; x++) {
                if(isPallindrome(x) && hasConsecutiveBaseSquareSum(x, d)) {
                    //System.out.println(x);
                    sum += x;
                }
            }
            
            System.out.println(sum);
        }
    }
}