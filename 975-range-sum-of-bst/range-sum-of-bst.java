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
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)return 0;
        // Queue<TreeNode>q=new LinkedList<>();
        // q.offer(root);
        // while(!q.isEmpty()){
        //     TreeNode temp=q.poll();
        //     if(temp.val>=low && temp.val<=high)sum+=temp.val;

        //     if(temp.left!=null)q.offer(temp.left);

        //     if(temp.right!=null)q.offer(temp.right);
        // }

        int sum=0;
        if(root.val>low){
           sum+=rangeSumBST(root.left,low,high);
        }
        if(root.val>=low && root.val<=high){
            sum+=root.val;
        }
        if(root.val<high){
            sum+=rangeSumBST(root.right,low,high);
        }
        return sum;
    }
}