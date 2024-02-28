//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int DivisibleByEight(String s){
        //code here
        int res=0;
        if(s.length()<=3){
            res=Integer.parseInt(s.substring(0,s.length()));
            if(res%8==0)
            return 1;
        }
        res=0;
        res=Integer.parseInt(s.substring(s.length()-3,s.length()));
            if(res%8==0)
            return 1;
        
        return -1;
    }
}