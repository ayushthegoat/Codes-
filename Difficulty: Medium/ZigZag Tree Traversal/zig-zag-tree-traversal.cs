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
            Queue<Node> queue = new Queue<Node>();
            queue.Enqueue(root);

            // Starting from the second element
            int i = 1;
            while (queue.Count != 0 && i < ip.Length)
            {

                // Get and remove the front of the queue
                Node currNode = queue.Peek();
                queue.Dequeue();

                // Get the current node's value from the string
                string currVal = ip[i];

                // If the left child is not null
                if (currVal != "N")
                {

                    // Create the left child for the current node
                    currNode.left = new Node(int.Parse(currVal));

                    // Push it to the queue
                    queue.Enqueue(currNode.left);
                }

                // For the right child
                i++;
                if (i >= ip.Length)
                    break;
                currVal = ip[i];

                // If the right child is not null
                if (currVal != "N")
                {

                    // Create the right child for the current node
                    currNode.right = new Node(int.Parse(currVal));

                    // Push it to the queue
                    queue.Enqueue(currNode.right);
                }
                i++;
            }

            return root;
        }
        
        void preorder(Node root){
            if(root==null){
                return;
            }
            
            Console.Write(root.data + " ");
            preorder(root.left);
            preorder(root.right);
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
                var res = obj.zigZagTraversal(root);
                foreach(int i in res){
                    Console.Write(i + " ");
                }
                Console.WriteLine();
            }

        }
    }


}

// } Driver Code Ends
//User function Template for C#

/*  A binary tree Node
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
*/
class Solution
{
   //Function to store the zig zag order traversal of tree in a list.
    public List<int> zigZagTraversal(Node root)
    {
    	// Code here
    	if(root == null) return new List<int>();
    	List<int>result = new List<int>();
    	Queue<Node> q = new Queue<Node>();
    	q.Enqueue(root);
    	bool leftToRight = true;
    	
    	while(q.Count > 0) {
    	    int size = q.Count;
    	    List<int> temp = new List<int>(new int[size]);
    	    
    	    for(int i=0;i<size;i++) {
    	        var node = q.Dequeue();
    	        
    	        int index = leftToRight? i :size - 1 - i;
    	        temp[index] = node.data;
    	        
    	        if(node.left != null) q.Enqueue(node.left);
    	        if(node.right != null) q.Enqueue(node.right);
    	    }
    	    foreach(var it in temp) {
    	        result.Add(it);
    	    }
    	    leftToRight = !leftToRight;
    	}
    	return result;
    	
    }
}

//{ Driver Code Starts.
// } Driver Code Ends