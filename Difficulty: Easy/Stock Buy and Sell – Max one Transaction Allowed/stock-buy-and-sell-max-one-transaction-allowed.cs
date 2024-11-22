//{ Driver Code Starts
// Initial Template for C#
using System;
using System.Linq;

// Position this line where user code will be pasted.
class GFG {
    public static void Main(string[] args) {
        int t = int.Parse(Console.ReadLine()); // Read number of test cases

        while (t-- > 0) {
            // Read input and convert to an array of integers
            int[] prices = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            Solution obj = new Solution();
            int result = obj.MaximumProfit(prices); // Calculate the maximum profit
            Console.WriteLine(result);              // Print the result
        }
    }
}

// } Driver Code Ends


class Solution {
    public int MaximumProfit(int[] prices) {
        // code here
        int buy = prices[0];
        int n = prices.Length;
        int profit = 0;
        for(int i = 1; i < n; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            } else {
                profit = Math.Max(profit, prices[i] - buy);
            }
        }
        return profit;
    }
}
