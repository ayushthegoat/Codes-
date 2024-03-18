class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int max=0;
        int counter=0;
        while(i<nums.length){
            if(nums[i]==0){
                counter++;
            }
            while(counter>k){
                   if(nums[j]==0){
                     counter--;
                   }
                   j++;
            }
            max=Math.max(max,i-j+1);
            i++;
        }
        return max;
    }
}