/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
           Queue<TreeNode> q = new ArrayDeque();
           if(root==null)return 0;
           if(root.left==null && root.right==null)return 1;

           int ctr=0;
           q.offer(root);
           while(!q.isEmpty()){
              TreeNode temp=q.poll();
              ctr++;

              if(temp.left!=null) q.offer(temp.left);

              if(temp.right!=null) q.offer(temp.right);

           }
           return ctr;
    }
}