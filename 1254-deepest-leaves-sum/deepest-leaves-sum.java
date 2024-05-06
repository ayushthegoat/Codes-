/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        int height = findDepth(root);
        return findSum(root, 0, height, 1);

    }

    private int findDepth(TreeNode root) {
        if (root == null)
            return 0;
        int lh = findDepth(root.left);
        int rh = findDepth(root.right);

        return Math.max(lh, rh) + 1;
    }

    private int findSum(TreeNode root, int sum, int height, int currheight) {
        if (root == null)
            return 0;

        if (height == currheight) {
            return sum + root.val;
        }

        int leftSum = findSum(root.left, sum, height, currheight + 1);
        int rightSum = findSum(root.right, sum, height, currheight + 1);

        return leftSum + rightSum;
    }
}