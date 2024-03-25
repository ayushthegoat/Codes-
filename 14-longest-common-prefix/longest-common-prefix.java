class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans=strs[0];
        for(int i=1;i<strs.length;i++){
            String x=compare(ans,strs[i]);
            if(x.equals(""))return "";
            ans=x;
        }
        return ans;


} 
    public String compare(String a,String b){
        int i = 0;
    while (i < a.length() && i < b.length()) {
        if (a.charAt(i) != b.charAt(i)) {
            break; 
        }
        i++;
    }
    return a.substring(0, i);
    }
    
}