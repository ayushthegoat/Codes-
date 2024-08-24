/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
   
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
          if (preorder.Length == 0 || inorder.Length == 0) {
        return null;
         }
         TreeNode root = new TreeNode(preorder[0]);

         int index = Array.IndexOf(inorder, preorder[0]);

         root.left = BuildTree(preorder[1..(index + 1)], inorder[..index]);
         root.right = BuildTree(preorder[(index + 1)..], inorder[(index + 1)..]);

         return root;

    }
}