//{ Driver Code Starts
//Initial Template for C#

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DriverCode
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
                int n = int.Parse(ip[0]);
                int m = int.Parse(ip[1]);
                string s1 = Console.ReadLine();
                string s2 = Console.ReadLine();
                Solution obj = new Solution();
                var res = obj.longestCommonSubstr(s1, s2, n, m);
                Console.WriteLine(res);
            }

        }
    }
}

// } Driver Code Ends


//User function Template for C#

class Solution
    {
        //Complete this function
        public int longestCommonSubstr(string S1, string S2, int n, int m)
        {
            //Your code here
          int[,] dp = new int[n + 1, m + 1];
          int max = 0;
        
        // Initialize dp array
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
              
                if (S1[i - 1] == S2[j - 1])
                {
                    dp[i, j] = dp[i - 1, j - 1] + 1;
                    max = Math.Max(dp[i, j], max);
                } else {
                    dp[i, j] = 0;
                }
                
            }
        }
        
        return max;
        }

    }