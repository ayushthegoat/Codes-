//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int max=0;
          char[] s1=S1.toCharArray();
          char[] s2=S2.toCharArray();
          
          int[][]dp=new int[s1.length+1][s2.length+1];
          
          for(int i=1;i<=s1.length;i++){
              for(int j=1;j<=s2.length;j++){
                  
                  
                  
                  if(s1[i-1]==s2[j-1]){
                      dp[i][j]=dp[i-1][j-1]+1;
                      max=Math.max(dp[i][j],max);
                  }else{
                      dp[i][j]=0;
                  }
                  
              }
              
          }
          return max;  
            
        }
      
    }
    
