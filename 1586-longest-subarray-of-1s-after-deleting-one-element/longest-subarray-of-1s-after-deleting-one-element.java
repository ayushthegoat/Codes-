class Solution {
    public int longestSubarray(int[] nums) {
        int i=0;
        int j=0;
        int max=0;
        int count=0;
        while(i<nums.length){
            if(nums[i]==0){
                count++;
            }
            while(count>1){
                if(nums[j]==0){
                    
                    count--;
                }
                j++;
            }
            max=Math.max(max,i-j);
            i++;
        }
        return max;
            }
}