//{ Driver Code Starts
//Initial Template for C#

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


class Node
{
    public int data;
    public Node left;
    public Node right;

    public Node(int key)
    {
        this.data = key;
        this.left = null;
        this.right = null;
    }
}

namespace DriverCode
{
    class GFG
    {
        // Function to Build Tree
        public Node buildTree(string str)
        {
            // Corner Case
            if (str.Length == 0 || str[0] == 'N')
                return null;

            // Creating vector of strings from input
            // string after spliting by space
            var ip = str.Split(' ');



            Node root = new Node(int.Parse(ip[0]));


            // Push the root to the queue


            // Starting from the second element
            int i = 1;
            Queue<Node> queue = new Queue<Node>();
            queue.Enqueue(root);
            while (queue.Count != 0 && i < ip.Length)
            {

                // Get and remove the front of the queue
                Node currNode = queue.Peek();
                queue.Dequeue();

                // Get the current Node's value from the string

                // if the left child is not null
                if (ip[i] != "N")
                {

                    // Create the left child for the current Node
                    currNode.left = new Node(int.Parse(ip[i]));

                    // Push it to the queue
                    queue.Enqueue(currNode.left);
                }

                // For the right child
                i++;
                if (i >= ip.Length)
                    break;
                // If the right child is not null

                if (ip[i] != "N")
                {

                    // Create the right child for the current Node
                    currNode.right = new Node(int.Parse(ip[i]));

                    // Push it to the queue
                    queue.Enqueue(currNode.right);
                }
                i++;
            }

            return root;
        }
        static void Main(string[] args)
        {
            int testcases;// Taking testcase as input
            testcases = Convert.ToInt32(Console.ReadLine());
            while (testcases-- > 0)// Looping through all testcases
            {
                var gfg = new GFG();
                var str = Console.ReadLine().Trim();
                var root = gfg.buildTree(str);
                Solution obj = new Solution();
                var res = obj.findMaxSum(root);
                Console.WriteLine(res);
            }

        }
    }
}
// } Driver Code Ends


//User function template for C#

class Solution
{
    //Complete this function
    //Function to return maximum path sum from any node in a tree.
    private  int res = int.MinValue;
    private int Solve(Node root) {
        if(root == null) return 0;
        
        int leftMax = Solve(root.left);
        int rightMax = Solve(root.right);
        
        int temp = Math.Max((Math.Max(leftMax, rightMax)) + root.data, root.data);
        int ans = Math.Max(leftMax + rightMax + root.data , temp);
        res = Math.Max(res, ans);
        return temp;
    }
    public int findMaxSum(Node root)
    {
        //Your code here
        if(root == null) return 0;
       
       Solve(root);
       return res;
    }
}