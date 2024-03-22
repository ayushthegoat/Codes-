class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        while(i<nums.length){
            sum=sum+nums[i];

            while(sum>=target && j<=i){
                min=Math.min(min,i-j+1);
                sum=sum-nums[j];
                j++;
            }
        
            i++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}