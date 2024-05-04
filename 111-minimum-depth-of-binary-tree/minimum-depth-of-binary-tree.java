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
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 1;

        Queue<TreeNode> q = new LinkedList();
        int currdepth = 1;
        int minDepth = Integer.MAX_VALUE;
        q.offer(root);
       

        while(!q.isEmpty()){
           int size = q.size();
           for(int i=0;i<size;i++){
            TreeNode temp = q.poll();
            if(temp.left==null && temp.right==null){
                 minDepth = Math.min(minDepth,currdepth);
            }
            if(temp.left!=null) q.offer(temp.left);
            if(temp.right!=null) q.offer(temp.right);
           }
            currdepth+=1;
        }
        return minDepth;
    }
}