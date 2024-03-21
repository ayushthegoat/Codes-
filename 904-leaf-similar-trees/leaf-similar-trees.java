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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       
        ArrayList<Integer> t1 = new ArrayList<>();
        ArrayList<Integer> t2 = new ArrayList<>();
        fillLists(root1,t1);
        fillLists(root2,t2);
        int j=0;
        if(t1.size()!=t2.size())return false;
        for(int i:t1){
            if(i!=t2.get(j++)){
                return false;
            }
        }
        return true;
    }
    public void fillLists(TreeNode root,ArrayList<Integer>list){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
            return ;
        }
        fillLists(root.left,list);
        fillLists(root.right,list);
    }
}