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

    private TreeNode Solve(TreeNode root, int start, int dest) {
        if(root == null) {
            return root;
        }

        if(root.val == start || root.val == dest) {
            return root;
        }

        TreeNode l = Solve(root.left, start, dest);
        TreeNode r = Solve(root.right, start, dest);

        if(l!=null && r!=null) {
            return root;
        }

        return l!=null ? l : r;
    }


    private bool FindPath(TreeNode root, int target, StringBuilder str) {
        if(root == null) {
            return false;
        }

        if(root.val == target) {
            return true;
        }

        str.Append('L');
        if(FindPath(root.left, target, str) == true) return true;

        str.Length--;
        str.Append('R');
        if(FindPath(root.right, target, str) == true) return true;

        str.Length--;
        return false;

    }

    public string GetDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = Solve(root, startValue, destValue);
        StringBuilder lcaToSrc = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();

        FindPath(LCA, startValue, lcaToSrc);
        FindPath(LCA, destValue, lcaToDest);

        StringBuilder ans = new StringBuilder();
        for(int i=0; i<lcaToSrc.Length; i++) {
            ans.Append('U');
        }

        ans.Append(lcaToDest);
        return ans.ToString();
    }
}