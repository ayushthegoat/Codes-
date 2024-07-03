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
                int K = Convert.ToInt32(Console.ReadLine());
                Solution obj = new Solution();
                long res = obj.substrCount(s, K);
                Console.Write(res+"\n");
          }

        }
    }
}


// } Driver Code Ends


//User function template for C#

class Solution
{
    //Complete this function
    private long solve(string s, int k) {
         long ans = 0;
        int cnt = 0;
        int size = s.Length;
        
        int i = 0;
        int j = 0;
        
        int[] hash = new int[26];
        
        while(j < size) {
            char chj = s[j];
            hash[chj - 'a']++;
            
            if(hash[chj - 'a'] == 1) cnt++;
            
            while(cnt > k) {
                char chi = s[i];
                hash[chi - 'a']--;
                
                if(hash[chi - 'a'] <= 0) {
                    cnt--;
                }
                i++;
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
    public long substrCount(string s, int k)
    {
        //Your code here
        return solve(s, k) - solve(s, k - 1);
       
    }
}