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
                string res = obj.removeDups(s);
                
                Console.Write(res);
                Console.Write("\n");
          }

        }
    }
    
    
}

// } Driver Code Ends


//User function template for C#
class Solution
{
    //Complete this function
    public string removeDups(string S)
    {
        
        string res = "";
        // Your code here
        int len = S.Length;
        int[] hash = new int[26];
        
        for(int i=0; i<len; i++) {
            hash[S[i] - 'a']++;
        }
        
        for(int i = 0; i < len; i++) {
            if(hash[S[i] - 'a'] >= 1) {
                hash[S[i] - 'a'] = 0;
                res+= S[i];
            }
        }
        return res;
    }
}