class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())return 0;
        int[] hash=new int[128];

        int i=0;
        int j=0;
        int max=0;

        while(i<s.length()){
            char ch=s.charAt(i);
            hash[ch]++;

            while(hash[ch]>1){
                char c=s.charAt(j);
                hash[c]--;
                j++;
            }
            
            max=Math.max(max,i-j+1);
            i++;
        }
    return max;
    }
}