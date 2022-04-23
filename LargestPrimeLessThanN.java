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
        ArrayList<Boolean> A;
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            A = new ArrayList<>();
            for(int i = 2; i <= n; i++) {
                A.add(true);
            }
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(A.get(i-2)) {
                    for(int j = 0; (i*i)+(j*i) <= n; j++) {
                        A.set(((i*i)+(j*i))-2, false);
                    }
                }
            }
            for(int i = A.size()-1; i >= 0; i--) {
                if(A.get(i)) {
                    System.out.println(i+2);
                    break;
                }
            }
        }
    }
}