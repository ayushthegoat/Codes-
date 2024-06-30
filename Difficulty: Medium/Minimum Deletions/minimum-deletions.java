//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
        //your code here
        int n = S.length();
        String str = new StringBuilder(S).reverse().toString();
        char[] ch1 = S.toCharArray();
        char[] ch2 = str.toCharArray();
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                
                if(ch1[i-1] == ch2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return Math.abs(dp[n][n] - n);
    
    }
}