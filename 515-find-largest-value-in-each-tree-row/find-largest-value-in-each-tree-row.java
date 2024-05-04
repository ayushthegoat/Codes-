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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)return new ArrayList<Integer>();

        List<Integer>list = new ArrayList();
        Queue<TreeNode>q = new LinkedList();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int mx = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                mx = Math.max(mx,temp.val);

                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            list.add(mx);
        }
        return list;
    }
}