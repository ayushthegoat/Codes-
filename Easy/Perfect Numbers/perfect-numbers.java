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
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPerfectNumber(long n) {
        // code here
        if(n==1)return 0;
        long sum=1;
      
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(i!=n/i){
                    sum+=(i+n/i);
                }else{
                    sum=sum+i;
                }
            }
        }
        return sum==n?1:0;
        
       // for(Integer i:list)System.out.print(i + " ");
    
    }
};