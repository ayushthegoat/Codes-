//{ Driver Code Starts
//Initial Template for C#


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DriverCode;

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
                string ip = Console.ReadLine().Trim();
                Solution obj = new Solution();
                List<string> res = obj.permutation(ip);
                foreach(string s in res){
                    Console.Write(s + " ");
                }
                Console.WriteLine();
                
          }

        }
    }
}
// } Driver Code Ends


class Solution
    {
          List<string> result;
        int n;
        
        private void Swap(int i, int j, char[] arr) {
            
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        private void Solve(string s, int index, char[] arr) {
            if(index >= n) {
                result.Add(new string(arr));
                return;
                
            }
                
                for(int i = index; i<n ; i++) {
                    Swap(i, index, arr);
                    Solve(s, index+1, arr);
                    Swap(i, index, arr);
                }
            }
        
        
        //Complete this function
        //Function to find all possible permutations of a given string.
        public List<string> permutation(string S)
        {
            //Your code here
            result = new List<string>();
            n = S.Length;
            char[] arr = S.ToCharArray();
            
            Solve(S, 0, arr);
            var sortedList = result.OrderBy(item => item).ToList();
          
            return sortedList;
        }
    }