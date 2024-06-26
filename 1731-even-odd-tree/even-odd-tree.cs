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
    public bool IsEvenOddTree(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> q = new Queue<TreeNode>();
        bool oddLevel = false;

        q.Enqueue(root);

        while(q.Count > 0) {
            int size = q.Count;
            int prevValue = oddLevel ? int.MaxValue : int.MinValue; // Initialize prevValue depending on the level

        for (int i = 0; i < size; i++) {
            var node = q.Dequeue();
            int val = node.val;

            if (oddLevel) { // Odd-indexed level
                if (val % 2 != 0 || val >= prevValue) return false; // Must be even and strictly decreasing
            } else { // Even-indexed level
                if (val % 2 == 0 || val <= prevValue) return false; // Must be odd and strictly increasing
            }

            prevValue = val;

            if (node.left != null) q.Enqueue(node.left);
            if (node.right != null) q.Enqueue(node.right);
        }
            oddLevel = !oddLevel;
        }
        return true;
    }
}