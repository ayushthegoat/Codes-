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
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        // code here
        int n=s.length();
        int[]res = new int[n];
        int len=0;
        int i=1;
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                 len++;
                 res[i]=len;
                 i++;
            }else{
                if(len!=0){
                    len=res[len-1];
                }else{
                    res[i]=0;
                    i++;
                }
            }
        }
        return res[n-1];
    }
}