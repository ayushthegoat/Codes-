class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i=0;
        int j=0;
        int sum=0;
        double max=Double.NEGATIVE_INFINITY;
        while(i<nums.length){
            sum=sum+nums[i];
          
            while(i-j+1>k){
                sum=sum-nums[j];
                j++;

            }
              if(i-j+1==k){
                max=Math.max(max,(double)sum/k);
            }
            i++;
        }
        return max;
    }
}