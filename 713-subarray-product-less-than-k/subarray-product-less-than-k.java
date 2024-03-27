class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0;
        int j=0;
        int product=1;
        int counter=0;
        while(i<nums.length){
            product=product*nums[i];

            while(product>=k && j<=i){
                product=product/(nums[j]);
                
                j++;
            }
            counter=counter+(i-j+1);
            i++;
        }
        return counter;
    }
}