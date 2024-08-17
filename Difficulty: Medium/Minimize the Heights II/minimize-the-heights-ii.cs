//{ Driver Code Starts
// Initial Template for C#

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
            int K = Convert.ToInt32(Console.ReadLine());
            int N = Convert.ToInt32(Console.ReadLine());
            int[] arr = new int[N];

            var ip = Console.ReadLine().Trim().Split(' ');
            for (int i = 0; i < N; i++) {
                arr[i] = int.Parse(ip[i]);
            }
            Solution obj = new Solution();
            var res = obj.getMinDiff(arr, N, K);
            Console.WriteLine(res);
        }
    }
}
}
// } Driver Code Ends


//User function template for C#

class Solution {

  //Complete this function
  public int getMinDiff(int[] arr, int n, int k) {
    //Your code here
    Array.Sort(arr);
    int diff = arr[n - 1] - arr[0];
    int smallest = arr[0] + k;
    int largest = arr[n - 1] - k;
    
    for(int i = 0; i < arr.Length - 1; i++)  {
        int mini = Math.Min(smallest, arr[i + 1] - k);
        int maxi = Math.Max(largest, arr[i] + k);
        if(mini < 0) {
            continue;
        }
        
        diff = Math.Min(diff, maxi - mini);
    }
    return diff;
  }
}