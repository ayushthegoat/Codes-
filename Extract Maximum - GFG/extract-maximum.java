//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String S = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.extractMaximum(S)); 
            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int extractMaximum(String S) 
    { int max=-1;
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                sb.append(S.charAt(i));
            } else if (sb.length() > 0) {
                int nums = Integer.parseInt(sb.toString());
                max = Math.max(max, nums);
                sb.setLength(0);
            }
        }

        if (sb.length() > 0) {
            int nums = Integer.parseInt(sb.toString());
            max = Math.max(max, nums);
        }

        return max;
    }    
} 
