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
                int N = Convert.ToInt32(Console.ReadLine());

                int[] arr = new int[3];

                string elements = Console.ReadLine().Trim();
                elements = elements + " " + "0";
                arr = Array.ConvertAll(elements.Split(), int.Parse);

                Solution obj = new Solution();
                int res = obj.maximizeTheCuts(N, arr[0], arr[1], arr[2]);
                Console.Write(res+"\n");
          }

        }
    }
}

// } Driver Code Ends


//User function Template for C#

class Solution
    {
        //Complete this function
        //Function to find the maximum number of cuts.
        
        private int Solve(ref int[] memo, int n, int x, int y, int z) {
            if(n == 0) {
                return 0;
            }
            if(n < 0) {
                return int.MinValue;
            }
            
            if(memo[n] != -1) {
                return memo[n];
            }
            
            int xS = Solve(ref memo, n-x, x, y, z) + 1;
            int yS = Solve(ref memo, n-y, x, y, z) + 1;
            int zS = Solve(ref memo, n-z, x, y, z) + 1;
            memo[n] = Math.Max(xS, Math.Max(yS, zS));
            
            return memo[n];
            
        }
        
        public int maximizeTheCuts(int n, int x, int y, int z)
        {
            //Your code here
            int[] memo = new int[n+1];
            for(int i=0; i<=n; i++) {
                memo[i] = -1;
            }
            int ans = Solve(ref memo, n, x, y, z);
            if(ans <=0){
                return 0;
            }
            return ans;
        }
    }