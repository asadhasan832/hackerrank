import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int product(String num) {
        int p = 1;
        for(String digit : num.split("")) {
            p *= Integer.parseInt(digit);
        }
        return p;
    }
    
    public static void getConsecutiveKDigitSums(String num, Stack<String> digitsGroups, int k) {
        if(num.length() < k) return;
        digitsGroups.push(num.substring(0, k));
        getConsecutiveKDigitSums(num.substring(1), digitsGroups, k);
    }

    public static int largestProductOfKConsecutiveDigitsInN(String num, int k) {
        int max = 0;
        Stack<String> digitsGroups = new Stack<String>();
        getConsecutiveKDigitSums(num, digitsGroups, k);
        //System.out.println(digitsGroups);
        while(digitsGroups.size() > 0) {
            max = Math.max(product(digitsGroups.pop()), max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            System.out.println(
              largestProductOfKConsecutiveDigitsInN(num, k)
            );
        }
    }
}