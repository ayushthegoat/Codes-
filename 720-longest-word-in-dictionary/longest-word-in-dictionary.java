class TreeNode{

    TreeNode[] children = new TreeNode[26];
    String word;

    TreeNode(){}
}
class Solution {
    private TreeNode root;
    private String result = "";

    public String longestWord(String[] words) {
       root = new TreeNode();

       for(String w : words){
           insert(w);
       }
       dfs(root);

       return result;
    }
    private  void insert(String word){
        TreeNode current = root;
        for(char ch : word.toCharArray()){
              if(current.children[ch - 'a'] == null)
                 current.children[ch - 'a'] = new TreeNode();
                 current = current.children[ch - 'a'];
        }
        current.word = word;
    }
    private void dfs(TreeNode node){
        if(node == null)return ;

        if(node.word!=null){
            if(node.word.length() > result.length()){
                result = node.word;
            }else if(node.word.length() == result.length() && node.word.compareTo(result)<0){
                result = node.word;
            }
        }

        for(TreeNode child : node.children){
            if(child!=null && child.word!=null){
                dfs(child);
            }
        }
    }
}