class Solution {
    public boolean canConstruct(String r, String m) {

        int[] hash = new int[26];
        for(int i=0;i<m.length();i++){
            char ch = m.charAt(i);
            hash[ch - 'a']++;
        }
         for(int i=0;i<r.length();i++){
            char ch = r.charAt(i);
            hash[ch - 'a']--;
            if(hash[ch - 'a']<0)return false;
        }
        return true;

    }
}