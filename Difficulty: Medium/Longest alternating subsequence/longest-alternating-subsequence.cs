//{ Driver Code Starts

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// Position this line where user code will be pasted.
namespace DriverCode {

class GFG {
    static void Main(string[] args) {
        int testcases; // Taking testcase as input
        testcases = Convert.ToInt32(Console.ReadLine());
        while (testcases-- > 0) // Looping through all testcases
        {
            List<int> nums = new List<int>();
            string[] input = Console.ReadLine().Split(' ');
            for (int i = 0; i < input.Length; i++) {
                nums.Add(int.Parse(input[i]));
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            Console.WriteLine(ans);
        }
    }
}
}
// } Driver Code Ends


// User function Template for C#

public class Solution {
    // Complete this function
    public int alternatingMaxLength(List<int> nums) {
          if (nums == null || nums.Count == 0) {
        return 0;
    }
        // code here
        int inc = 1;
        int dec = 1;
        
        for(int i = 1; i < nums.Count; i++) {
            if(nums[i] > nums[i - 1]) {
                inc = dec + 1;
            } else if (nums[i] < nums[i - 1]) {
                dec = inc + 1;
            }
        }
        return Math.Max(inc, dec);
    }
}