//{ Driver Code Starts
//Initial Template for C#

using System;
using System.Numerics;
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
                int[] val = new int[N];
                int[] wt = new int[N];
                int K = Convert.ToInt32(Console.ReadLine());
                string elements = Console.ReadLine().Trim();
                elements = elements + " " + "0";
                val = Array.ConvertAll(elements.Split(), int.Parse);
                elements = Console.ReadLine().Trim();
                elements = elements + " " + "0";
                wt = Array.ConvertAll(elements.Split(), int.Parse);
                Solution obj = new Solution();
                int res = obj.knapSack(K,wt,val, N);
                Console.Write(res+"\n");
          }

        }
    }
}

// } Driver Code Ends


//User function Template for C#


class Solution
    {
        private int[,] t;
        private int Solve(int[] wt, int[] val, int weight, int index) {
            if(weight == 0 || index == 0) {
                return 0;
            }
            
            if(t[weight, index] != -1) {
                return t[weight, index];
            }
            
            int currWeight = wt[index-1];
            if(currWeight <= weight) {
                int take = val[index-1] + Solve(wt, val, weight-currWeight, index-1);
                int not  = Solve(wt, val, weight, index-1);
                
                t[weight, index] = Math.Max(take, not);
                
                return t[weight, index];
            } else {
              
                t[weight, index] =  Solve(wt, val, weight, index-1);
                return t[weight, index];
            }
        
        }
        
        //Complete this function
        public int knapSack(int w, int[] wt, int[] val,int n)
        {
            //Your code here
              t = new int[w + 1, n + 1];
        for(int i = 0; i <= w; i++) {
            for(int j = 0; j <= n; j++) {
                t[i, j] = -1;
            }
        }
            
            return Solve(wt, val, w, n);
            
        }

    }