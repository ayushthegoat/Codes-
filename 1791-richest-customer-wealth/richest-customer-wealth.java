class Solution {
    public int maximumWealth(int[][] accounts) {
       int sum = 0;
       int max=0;
       for(int[] s : accounts){
        sum = 0;
        for(int i=0;i<s.length;i++){
            sum = sum + s[i];
        }
        max = Math.max(sum,max);
        
       }
       return max;
    }
}