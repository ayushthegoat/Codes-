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
    IList<int> result = new List<int>();
    public IList<int> PostorderTraversal(TreeNode root) {
        Solve(root);
        return result;
    }

    private void Solve(TreeNode root) {
        if (root == null) {
            return;
        } 
        Solve(root.left);
        Solve(root.right);
        result.Add(root.val);
    }
}