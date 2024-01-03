//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        
        
        
        char[] s1=str.toCharArray();
    char[] s2=sb.toString().toCharArray();
        int[][] dp;
        // your code here
    dp = new int[str.length()+1][str.length()+1];
        for(int i=0;i<=s1.length;i++){
            for(int j=0;j<=s2.length;j++){
                if(i==0 || j==0) dp[i][j] =0;
                else{
                    if(s1[i-1]==s2[j-1]) {
                        dp[i][j]=1+dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        int res=str.length()-dp[str.length()][str.length()];
        return res;
    }
    
}