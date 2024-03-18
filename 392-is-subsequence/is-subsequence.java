class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;

        while(i<s.length() && j<t.length()){
            char ss=s.charAt(i);
            char tt=t.charAt(j);

            if(ss==tt){
                i++;
                j++;
            }else{
                j++;
            }
        }
       return i==s.length();
    }
}