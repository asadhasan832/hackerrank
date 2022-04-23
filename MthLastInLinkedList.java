import java.io.*;
import java.util.*;

public class MthLastInLinkedList {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String line = "Start";
        BufferedReader stream = new BufferedReader(new InputStreamReader(System.in));
        Long M = 0L;
        Long input_count = 0L;
        LinkedList<String> list;
        
        while(true) {
            input_count++;  
            try {
               line = stream.readLine();
            } catch(IOException e) {
                break;
            }
            if(line == null) break;
            if(input_count%2 != 0) M = Long.parseLong(line);
            if(input_count%2 == 0) {
                 list = new LinkedList<String>();
                 for(String item : line.split(" ")) {
                     list.add(item);
                 }
                
                Iterator<String> itr = list.descendingIterator();
                String output = "NIL";
                Long i = 0L;
                while(itr.hasNext()) {
                    i++;
                    if(M == i) {
                        output = itr.next();
                    } else {
                        itr.next();
                    }
                }
                System.out.println(output); 
            }
        }
    }
}
