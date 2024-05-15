class TrieNode {
    TrieNode[] children = new TrieNode[10];
    boolean end = false;

    TrieNode() {
        for (int i = 0; i < 10; i++) {
            children[i] = null;
        }
    }
}

class Solution {
    private TrieNode root;

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - '0';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.end = true;
    }

    public int search(String word){
        int cnt = 0;
        TrieNode current  = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            int idx = ch-'0';
            if(current.children[idx]==null){
                break;
            }
            cnt++;
            current = current.children[idx];
        }
        return cnt;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new TrieNode();
        for(int i=0;i<arr1.length;i++){
            insert(Integer.toString(arr1[i]));
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr2.length;i++){
            max = Math.max(max,search(Integer.toString(arr2[i])));
        }
        return max;
    }
}