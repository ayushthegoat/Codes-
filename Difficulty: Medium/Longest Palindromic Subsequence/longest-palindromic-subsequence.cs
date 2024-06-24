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
                string s = Console.ReadLine().Trim();
                Solution obj = new Solution();
                int res = obj.longestPalinSubseq(s);
                Console.Write(res);
                Console.Write("\n");
          }

        }
    }
}

// } Driver Code Ends


//User function Template for C#

class Solution
    {
        //Complete this function
        private string reverse(string str) {
            char[] arr = str.ToCharArray();
            Array.Reverse(arr);
            return new string(arr);
        }
        public int longestPalinSubseq(string A)
        {
            //code here
            string temp = A;
            temp = reverse(temp);
            int n = temp.Length;
            
            int[,] dp = new int[n+1, n+1];
            
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    
                    if(A[i-1] == temp[j-1]) {
                      dp[i, j] = 1 + dp[i-1, j-1];  
                    } else {
                      dp[i, j] = Math.Max(dp[i-1, j], dp[i, j-1]);
                    }
                    
                }
            }
            return dp[n, n];
        }
    }