//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int n = str.length();
        int m = n;
        int[][] dp = new int[n + 1][m + 1];
        char[] arr = str.toCharArray();
      
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
               if(arr[i-1] == arr[j-1] && i != j ){
                   dp[i][j] = 1 + dp[i-1][j-1];
               } else {
                   dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
               }
            }
        }
        return dp[n][m];
    }
}