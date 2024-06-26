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
                int[] arr = new int[2];
                string elements = Console.ReadLine().Trim();
                elements = elements + " " + "0";
                arr = Array.ConvertAll(elements.Split(), int.Parse);
                int sum = arr[0];
                int N = arr[1];
                int[] coins = new int[N];
                string elements1 = Console.ReadLine().Trim();
                coins = Array.ConvertAll(elements1.Split(), int.Parse);
                Solution obj = new Solution();
                long res = obj.count(coins, N, sum);
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
        //Function to count the number of ways to make change for given coins.
        private long[,] memo;
        public long count(int[] coins, int N, int sum)
        {
            //Your code here
            memo = new long[N + 1, sum + 1];
            
              for (int i = 0; i <= N; i++) {
            memo[i, 0] = 1;
        }

            for (int i = 1; i <N+1; i++) {
            for (int j = 1; j <sum+1; j++) {
                
                if(j - coins[i-1] >= 0) {
                    long take = memo[i, j - coins[i-1]];
                    long notTake = memo[i - 1, j];
                    
                    memo[i, j] = take + notTake;
                } else {
                    memo[i, j] = memo[i - 1, j];
                }
            }
        }
            
            return memo[N, sum];
        }
       
    }