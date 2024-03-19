class Solution {
    public int largestAltitude(int[] gain) {
        int sum=0;
        int max=0;
        for(int s:gain){
            sum+=s;
            max=Math.max(sum,max);
        }
        return max;
    }
}