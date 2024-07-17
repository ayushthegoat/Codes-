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

    private TreeNode Solve(TreeNode root, HashSet<int> st, IList<TreeNode> res) {
        if(root == null) {
            return null;
        }

        root.left = Solve(root.left, st, res);
        root.right = Solve(root.right, st, res);

        if(st.Contains(root.val)) {
            if(root.left != null) {
                res.Add(root.left);
            }

            if(root.right != null) {
                res.Add(root.right);
            }

            return null;
        } else {
            return root;
        }
    }

    public IList<TreeNode> DelNodes(TreeNode root, int[] to_delete) {
        var res = new List<TreeNode>();
        HashSet<int> st = new HashSet<int>();

        foreach(var item in to_delete) {
            st.Add(item);
        }
      
        Solve(root, st, res);

        if(!st.Contains(root.val)) {
            res.Add(root);
        }

        return res;
    }

}