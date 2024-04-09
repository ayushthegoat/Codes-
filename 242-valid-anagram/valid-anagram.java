class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] hash  = new int[26];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hash[ch - 'a']++;
        }
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            hash[ch - 'a']-- ;
            if(hash[ch - 'a']<0)return false;
        }
        return true;
    }
}