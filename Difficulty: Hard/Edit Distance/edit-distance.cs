//{ Driver Code Starts
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DriverCode {

class GFG {
    static void Main(string[] args) {
        int testcases; // Taking testcase as input
        testcases = Convert.ToInt32(Console.ReadLine());
        while (testcases-- > 0) // Looping through all testcases
        {
            string[] s = Console.ReadLine().Trim().Split();
            string S = s[0];
            string S1 = s[1];
            Solution obj = new Solution();
            int res = obj.editDistance(S, S1);
            Console.Write(res);
            Console.Write("\n");
        }
    }
}
}
// } Driver Code Ends


// User function Template for C#

class Solution {
    // Complete this function
    // Function to find the minimum number of operations required to transform
    // one string into the other.
    public int editDistance(string str1, string str2) {
        // Your code here
        int n = str1.Length;
        int m = str2.Length;
        int[,] dp = new int[n + 1, m + 1];
        
        for(int i = 0; i < n + 1; i++) {
            dp[i, 0] = i;
            
        }
        for(int j = 0; j < m + 1; j++) {
            dp[0, j] = j;
        }
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                
                if(str1[i - 1] == str2[j - 1]) {
                    dp[i, j] = dp[i - 1, j - 1];
                } else {
                    dp[i, j] = 1 + Math.Min(Math.Min(dp[i, j - 1], dp[i - 1, j]), dp[i - 1, j - 1]);
                }
             }
        }
        return dp[n, m];
    }
}