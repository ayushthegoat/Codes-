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
                Solution obj = new Solution();
                long res = obj.toh(N, 1, 3, 2);
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
    public long toh(int n, int from, int to, int aux)
    {
        //Your code here
        if(n == 1) {
            Console.WriteLine("move disk "+ n +" from rod "+ from +" to rod "+ to);
            return 1;
        }
        
        long count = 0;
        count += toh(n-1, from, aux, to);
        Console.WriteLine("move disk "+ n +" from rod "+ from +" to rod "+ to);
        
        count +=1;
        
        count += toh(n-1, aux, to, from);
        return count;
        
    }
}