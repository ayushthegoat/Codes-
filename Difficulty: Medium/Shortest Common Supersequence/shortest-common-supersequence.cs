//{ Driver Code Starts
//Initial Template for C#


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace driverCode
{

    class GFG
    {
        static void Main(string[] args)
        {
            int testcases;// Taking testcase as input
            testcases = Convert.ToInt32(Console.ReadLine());
            while (testcases-- > 0)// Looping through all testcases
            {

                var ip = Console.ReadLine().Trim().Split(' ');
                string X = ip[0];
                string Y = ip[1];

                Solution obj = new Solution();
                int res = obj.shortestCommonSupersequence(X, Y, X.Length, Y.Length);
                Console.Write(res+"\n");
            }

        }
    }
}

// } Driver Code Ends


//User function template for C#

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public int shortestCommonSupersequence(string X, string Y, int n, int m)
    {
        //code here
        int[,] dp = new int[n+1, m+1];
        char[] arr1 = X.ToCharArray();
        char[] arr2 = Y.ToCharArray();
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i, j] = 1 + dp[i-1, j-1];
                } else {
                    dp[i, j] = Math.Max(dp[i, j-1], dp[i-1, j]);
                }
                
            }
        }
        
        return (n + m) - dp[n, m];
    }
}