//{ Driver Code Starts
// Initial Template for C#

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class Node {
    public int data;
    public Node left;
    public Node right;
    public Node nextRight;

    public Node(int key) {
        this.data = key;
        this.left = null;
        this.right = null;
        this.nextRight = null;
    }
}

namespace DriverCode {

class GFG {

    void sort_and_print(List<int> v) {
        v.Sort();
        for (int i = 0; i < v.Count; i++) Console.Write(v[i] + " ");
        v.Clear();
    }

    void printLevelOrder(Node root) {
        List<int> v = new List<int>();
        Queue<Node> q = new Queue<Node>();

        q.Enqueue(root);

        Node next_row = null;

        while (q.Count > 0) {
            Node n = q.Peek();
            q.Dequeue();

            if (n == next_row) {
                sort_and_print(v);
                next_row = null;
            }

            v.Add(n.data);

            if (n.left != null) {
                q.Enqueue(n.left);
                if (next_row == null) next_row = n.left;
            }

            if (n.right != null) {
                q.Enqueue(n.right);
                if (next_row == null) next_row = n.right;
            }
        }
        sort_and_print(v);
    }

    static void Main(string[] args) {
        int testcases; // Taking testcase as input
        testcases = Convert.ToInt32(Console.ReadLine());
        while (testcases-- > 0) // Looping through all testcases
        {
            var gfg = new GFG();
            int n = Convert.ToInt32(Console.ReadLine());
            var ipArr = Console.ReadLine().Trim().Split(' ');
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = int.Parse(ipArr[i]);
            }
            Solution obj = new Solution();
            var res = obj.createTree(arr);
            gfg.printLevelOrder(res);
            Console.WriteLine();
        }
    }
}

}

// Position this line where user code will be pasted.
// } Driver Code Ends


// User function Template for C#

class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int[] paren) {
        // code here
        Dictionary<int, Node> dick = generateMap(paren.Length);
        int par = -1;
        
        for(int i = 0; i < paren.Length; i++) {
            if(paren[i] == -1) {
                par = i;
                continue;
            }
            
            Node curr = dick[i];
            Node parent = dick[paren[i]];
            
            if(parent.left == null) {
                parent.left = curr;
            } else {
                parent.right = curr;
            }
        }
        return dick[par];
        
    }
    
    private Dictionary<int, Node> generateMap(int len) {
        Dictionary<int, Node> dick = new Dictionary<int, Node>();
        
        for(int i = 0; i < len; i++) {
            dick[i] = new Node(i);
            
        }
        
        return dick;
    }
}