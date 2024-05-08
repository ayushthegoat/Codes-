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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<Long>q = new PriorityQueue<>((a,b)->Long.compare(b,a));
        Queue<TreeNode> qq = new LinkedList();

        qq.offer(root);
        while(!qq.isEmpty()){
            int size = qq.size();
            long sum = 0;
            for(int i=0;i<size;i++){
                TreeNode temp = qq.poll();
                sum+=temp.val;

                if(temp.left!=null) qq.offer(temp.left);
                if(temp.right!=null) qq.offer(temp.right);
            }
            q.offer(sum);
        }
        k--;
        while(k-->0){
            System.out.println(q.peek());
            q.poll();
            

        }
        if(q.size()==0)return -1;
        return q.peek();
    }
}