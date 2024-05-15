class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean end = false;

    TrieNode(){}
}
class WordDictionary {

    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();

    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.end = true;
    }
    
    public boolean search(String word){
        return searchUtil(word,root);
    }
    public boolean searchUtil(String word,TrieNode root) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);

            if(c=='.'){
                for(int j=0;j<26;j++){
                    if(curr.children[j]!=null){
                        if(searchUtil(word.substring(i+1),curr.children[j])){
                            return true;
                        }
                    } 
                }
                return false;
            }else{
                int idx = c-'a';
                if(curr.children[idx]==null)return false;
                curr = curr.children[idx];
            }
           
        }
         if(curr.end)return true;
         return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */