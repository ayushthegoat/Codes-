//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
       boolean isValid = false;
       
       String[] afterSplit = str.split("\\.");
       if(afterSplit.length != 4) {
           return false;
       }
       for(int i = 0; i < afterSplit.length; i++) {
           String curr = afterSplit[i];
              if(curr.isEmpty()) {
               return false;
           }
           char isZero = curr.charAt(0);
           if(isZero == '0' && curr.length() > 1){
               return false;
           }
        
           int converted = Integer.parseInt(curr);
          // System.out.println(converted);
           if(converted <= 255 && converted >= 0) {
               continue;
           } else {
               return false;
           }
           
       }
       
       return true;
    }
}