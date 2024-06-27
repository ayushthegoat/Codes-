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
    private int max = int.MinValue;

    private int Solve(TreeNode root) {
        if(root == null) return 0;


        int leftMax = Math.Max(0, Solve(root.left));
        int rightMax = Math.Max(0, Solve(root.right));

        int temp = Math.Max(leftMax, rightMax) + root.val;
        max = Math.Max(max, leftMax + rightMax + root.val);
        return temp;
    }

    public int MaxPathSum(TreeNode root) {
        if(root == null) return 0;

        Solve(root);
        return max;
    }
}