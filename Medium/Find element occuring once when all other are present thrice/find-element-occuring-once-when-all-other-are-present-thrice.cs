//{ Driver Code Starts
// Initial Template for C#

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
                int[] arr = new int[N];

                var stringArray = Console.ReadLine().Split(' ');
                for (int i = 0; i < N; i++)
                {
                    arr[i] = int.Parse(stringArray[i]);
                }
                Solution obj = new Solution();
                int res = obj.singleElement(arr, N);
                Console.Write(res);
                Console.Write("\n");
          }

        }
    }
}
// } Driver Code Ends


//User function Template for Csharp

class Solution
{
    //Complete this function
    public int singleElement(int[] arr ,int N)
    {
        //Your code here
       Dictionary<int ,int>dic=new Dictionary<int ,int>();
       for (int i = 0; i < arr.Length; i++)
    {
        if (dic.TryGetValue(arr[i], out int ctr))
        {
            dic[arr[i]] = ++ctr; }
        else
        {
            dic[arr[i]] = 1; 
        }
    }
       foreach(KeyValuePair<int,int>k in dic){
           if(k.Value==1)return k.Key;
       }
       return -1;
    }
}