import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int i = 1;
            boolean divisible = false;
            while(true) {
                divisible = false;
                for(int j = 1; j <= n; j++) {
                    if(i%j != 0) break;
                    if(j == n) divisible = true;
                }
                if(divisible) {
                    System.out.println(i);
                    break;
                }
                i++;
            }
        }
    }
}