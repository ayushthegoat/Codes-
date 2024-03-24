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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<Double> res = new ArrayList();
        q.offer(root);
        q.offer(null);
         

        while(q.peek()!=null){
            double sum=0;
            int num=0;
            
            while(q.peek()!=null){
                TreeNode temp=q.poll();
                sum+=temp.val;
                num++;

                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);

            }
            q.offer(q.poll());
            res.add(sum/num);
          
        }
        return res;

    }
}