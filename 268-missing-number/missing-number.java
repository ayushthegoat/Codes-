class Solution {
    public int missingNumber(int[] nums) {
    
        int normalsum=((nums.length)*((nums.length)+1))/2;
        for(int i=0;i<nums.length;i++){
                normalsum = normalsum - nums[i];
        }
        return normalsum;
    }
}