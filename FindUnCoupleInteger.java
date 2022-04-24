import java.io.*;
import java.util.*;

/*
Given the input
1, 2, 3, 1, 2
your program should output:
3
*/

public class Solution {
    private static void findUncoupled(String[] items) {
        int output = 0;
        for(String item : items) {
            //XOR all integers leaving behind the uncoupled
            output ^= Integer.parseInt(item);
        }
        System.out.println(output);
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String line = "Start";
        BufferedReader stream = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            try {
               line = stream.readLine();
            } catch(IOException e) {
                break;
            }
            if(line == null) break;
            String[] items = line.split(", ");
            findUncoupled(items);
        }
    }
}a