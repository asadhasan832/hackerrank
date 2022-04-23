import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    // N(N+1)/2
    // 3*SUM + 5*SUM - 15*SUM, with scaled bounds
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            Long bound3 = Long.valueOf((n-1)/3);
            Long bound5 = Long.valueOf((n-1)/5);
            Long bound15 = Long.valueOf((n-1)/15);
            Long sum = (3*(bound3*(bound3+1)/2)) + (5*(bound5*(bound5+1)/2)) - (15*(bound15*(bound15+1)/2));
            System.out.println(sum);
        }
    }
}
