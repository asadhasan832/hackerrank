import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        //HashMap<Set, Integer> products = new HashMap<>();
        long max = 0;
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                try {
                   max = Long.max(max , grid[grid_i][grid_j] * grid[grid_i+1][grid_j] * grid[grid_i+2][grid_j] * grid[grid_i+3][grid_j] );
                } catch(Exception e) {
                    //System.out.println(e);
                }   
                
                try{
                   max = Long.max(max , grid[grid_i][grid_j]
                   * grid[grid_i][grid_j+1]
                   * grid[grid_i][grid_j+2]
                   * grid[grid_i][grid_j+3]);
                } catch(Exception e) {}
                    
                try{
                   max = Long.max(max , grid[grid_i][grid_j]
                   * grid[grid_i+1][grid_j+1]
                   * grid[grid_i+2][grid_j+2]
                   * grid[grid_i+3][grid_j+3]);
                } catch(Exception e) {}
                    
                try{
                   max = Long.max(max , grid[grid_i][grid_j]
                   * grid[grid_i-1][grid_j+1]
                   * grid[grid_i-2][grid_j+2]
                   * grid[grid_i-3][grid_j+3]);
                } catch(Exception e) {}
                
                try{
                   max = Long.max(max , grid[grid_i][grid_j]
                   * grid[grid_i-1][grid_j-1]
                   * grid[grid_i-2][grid_j-2]
                   * grid[grid_i-3][grid_j-3]);
                } catch(Exception e) {}
                   
                try{ 
                   max = Long.max(max , grid[grid_i][grid_j]
                   * grid[grid_i][grid_j-1]
                   * grid[grid_i][grid_j-2]
                   * grid[grid_i][grid_j-3]);
                } catch(Exception e) {}
                    
                try{
                   max = Long.max(max , grid[grid_i][grid_j]
                   * grid[grid_i-1][grid_j]
                   * grid[grid_i-2][grid_j]
                   * grid[grid_i-3][grid_j]);
                } catch(Exception e) {}
                
                try{ 
                   max = Long.max(max , grid[grid_i][grid_j]
                   * grid[grid_i+1][grid_j-1]
                   * grid[grid_i+2][grid_j-2]
                   * grid[grid_i+3][grid_j-3]);
                } catch(Exception e) {}
            }
        }
        System.out.println(max);
    }
}