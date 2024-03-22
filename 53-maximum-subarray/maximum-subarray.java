class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
         int totsum=Integer.MIN_VALUE;
         int sum=0;
         for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
           totsum=sum>totsum?sum:totsum;
            if(sum<0){
                sum=0;
            }
         }
         return totsum;
    }
}