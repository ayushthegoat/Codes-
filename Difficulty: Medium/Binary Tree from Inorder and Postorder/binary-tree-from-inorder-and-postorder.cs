//{ Driver Code Starts
// Initial Template for C#

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DriverCode;

namespace DriverCode {

public class GFG {
    public static void Main(string[] args) {
        int testcases; // Taking testcase as input
        testcases = Convert.ToInt32(Console.ReadLine());
        while (testcases-- > 0) // Looping through all testcases
        {

            int n = Convert.ToInt32(Console.ReadLine()); // Input for size of array
            int[] inorder = new int[n];
            string elements = Console.ReadLine().Trim();
            elements = elements + " " + "0";
            inorder = Array.ConvertAll(elements.Split(' '), int.Parse);
            elements = Console.ReadLine().Trim();
            elements = elements + " " + "0";
            int[] postorder = Array.ConvertAll(elements.Split(' '), int.Parse);

            Solution obj = new Solution();
            var res = obj.buildTree(inorder, postorder, n);
            preorder(res);
            Console.WriteLine();
        }
    }

    public static void preorder(Solution.TreeNode root) {
        if (root == null) {
            return;
        }
        Console.Write(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
}

// } Driver Code Ends


// User function Template for C#

public class Solution {
    // Definition for a binary tree node.
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    private TreeNode solve(int[] inorder, int[] postorder, int inSt, int inEnd, int postSt, int postEnd) {
        
        if(inSt > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int i = inSt;
        for(; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                break;
            }
        }
        
        int leftLen = i - inSt;
        int rightLen = inEnd - i;
        
        root.left = solve(inorder, postorder, inSt, i - 1, postSt, postSt + leftLen - 1);
        root.right = solve(inorder, postorder, i + 1, inEnd, postEnd - rightLen, postEnd - 1);
        
        return root;
        
    }
    // Function to return a tree created from postorder and inorder traversals.
    public TreeNode buildTree(int[] inorder, int[] postorder, int n) {
        // Your code here
       
        int inSt = 0;
        int inEnd = n - 1;
        
        int postSt = 0;
        int postEnd = n - 1;
        
        return solve(inorder, postorder, inSt, inEnd, postSt, postEnd);
    }
}