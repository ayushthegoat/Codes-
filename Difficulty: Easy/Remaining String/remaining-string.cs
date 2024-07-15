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
            string s = Console.ReadLine().Trim();
            char ch = Convert.ToChar(Console.ReadLine());
            int count = Convert.ToInt32(Console.ReadLine());
            Solution obj = new Solution();
            string res = obj.printString(s, ch, count);
            Console.Write(res);
            Console.Write("\n");
        }
    }
}
}
// } Driver Code Ends


// User function Template for C#

public class Solution {
    // Complete this function
    public string printString(string s, char ch, int count) {
        // Your code here
        int len = s.Length;
        string ans = "";
        int i = 0;
        while(i < len) {
            if(s[i] == ch) {
                count--;
            }
            if(count == 0 && i < len) {
                ans = s.Substring(i+1);
                break;
            }
            i++;
        }
        return ans;
    }
}