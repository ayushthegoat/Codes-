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

                int n = Convert.ToInt32(Console.ReadLine());
                var stringArray = Console.ReadLine().Split(' ');
                List<int> arr = new List<int>();
                foreach (var arrElem in stringArray)
                    arr.Add(int.Parse(arrElem));

                Solution obj = new Solution();
                int res = obj.goodStones(n, arr);
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
    Stack<int> s = new Stack<int>(); // Stack to keep track of processed nodes

    bool DFS(List<int>[] adj, int node, List<int> vis, List<int> path)
    {
        vis[node] = 1;   // Mark the node as visited
        path[node] = 1;  // Mark the node as part of the current path

        foreach (var neighbor in adj[node])
        {
            if (vis[neighbor] == 0)
            {
                if (DFS(adj, neighbor, vis, path))
                {
                    return true;
                }
            }
            else if (path[neighbor] == 1)
            {
                return true;
            }
        }

        path[node] = 0; // Mark the node as not part of the current path
        s.Push(node);   // Push the node onto the stack
        return false;
    }

    public int goodStones(int n, List<int> arr)
    {
        // Initialize adjacency list
        List<int>[] adj = new List<int>[n];
        for (int i = 0; i < n; i++)
        {
            adj[i] = new List<int>(); // Initialize each list
        }

        // Build the adjacency list
        for (int i = 0; i < n; i++)
        {
            int node = i + arr[i];
            if (node >= 0 && node < n)
            {
                adj[i].Add(node);
            }
        }

        // Initialize visit and path lists
        List<int> vis = new List<int>(new int[n]);
        List<int> path = new List<int>(new int[n]);

        // Perform DFS for each unvisited node
        for (int i = 0; i < n; i++)
        {
            if (vis[i] == 0)
            {
                DFS(adj, i, vis, path);
            }
        }

        // Return the number of nodes in the stack
        return s.Count;
    }
        
    
   
}