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
            List<int> temp = new List<int>();
            for(int i=0;i<size;i++) {
                var node = q.Dequeue();
                temp.Add(node.val);

                if(node.left != null) q.Enqueue(node.left);
                if(node.right != null) q.Enqueue(node.right);
            }
            if (!oddLevel) { // Even-indexed level
            if (temp[0] % 2 == 0) return false; // The first element must be odd
            for (int i = 1; i < temp.Count; i++) {
                if (temp[i] % 2 == 0 || temp[i] <= temp[i - 1]) return false; // Odd and strictly increasing
            }
        } else { // Odd-indexed level
            if (temp[0] % 2 != 0) return false; // The first element must be even
            for (int i = 1; i < temp.Count; i++) {
                if (temp[i] % 2 != 0 || temp[i] >= temp[i - 1]) return false; // Even and strictly decreasing
            }
        }
            oddLevel = !oddLevel;
        }
        return true;
    }
}