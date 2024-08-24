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
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        int n = inorder.Length;

        int inSt = 0;
        int inEnd = n - 1;
        
        int postSt = 0;
        int postEnd = n - 1;
        
        return solve(inorder, postorder, inSt, inEnd, postSt, postEnd);
    }
}