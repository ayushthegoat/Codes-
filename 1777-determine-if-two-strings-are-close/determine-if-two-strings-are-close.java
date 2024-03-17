class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] hash1=new int[26];
        int[] hash2=new int[26];

        for(char ch:word1.toCharArray()){
            hash1[ch-'a']++;
        }
        for(char ch:word2.toCharArray()){
            hash2[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if((hash1[i]==0 && hash2[i]!=0) || (hash1[i]!=0 && hash2[i]==0)){
                return  false;
            }
        }
        Arrays.sort(hash1);
        Arrays.sort(hash2);
        for(int i=0;i<26;i++){
            if(hash1[i]!=hash2[i])return false;
        }
        return true;
    }
}