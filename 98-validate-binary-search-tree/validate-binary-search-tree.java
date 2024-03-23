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
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        final ArrayList<Integer>list=new ArrayList<>();
        inOrder(root,list);
        for(int i=1;i<list.size();i++){
            if(list.get(i-1)>=list.get(i)){
                return false;
            }
        }
        return true;
    }
    private void inOrder(TreeNode root,ArrayList<Integer>list){
        if(root==null)return ;

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}