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
                List<int> start = new List<int>();
                List<int> end = new List<int>();

                start = Console.ReadLine().Trim().Split(' ').ToList().Select(int.Parse).ToList();
                end = Console.ReadLine().Trim().Split(' ').ToList().Select(int.Parse).ToList();

                Solution obj = new Solution();
                int res = obj.activitySelection(start,end,N);
                Console.Write(res+"\n");
          }

        }
    }
}

// } Driver Code Ends


class Solution
{
    //Complete this function
    public int activitySelection(List<int> start, List<int> end, int n)
    {
        //Your code here
        var list = new List<(int, int)>();
        for(int i = 0; i < start.Count; i++) {
           var tupler = (start[i], end[i]);
           list.Add(tupler);
        }
        int count = 0;
        
          var sorted = list.OrderBy(t => t.Item2).ThenBy(t => t.Item1).ToList();
          
           int lastEndTime = -1;

    // Iterate through the sorted list of activities
    foreach (var tup in sorted)
    {
        if (tup.Item1 > lastEndTime)
        {
            // If the start time of the current activity is greater than
            // the end time of the last selected activity, select this activity
            count++;
            lastEndTime = tup.Item2;
        }
    }
          return count;
        
    }
}