class Solution {
    public int firstMissingPositive(int[] nums) {
          int i=0;
        
         
            while(i<nums.length){
               
                int correct = nums[i]-1;
               
                if(nums[i]>0 && nums[i] < nums.length && nums[i]!=nums[correct]){
                swap(i,correct,nums);
                }else{
                    i++;
                }
            }
            int sPM = 1;
            for(int x=0;x<nums.length;x++){
                if(nums[x]==sPM){
                    sPM++;
                }
            }
           return sPM;
    }
    public void swap(int idx1, int idx2, int[] nums){
            int temp=nums[idx1];
            nums[idx1]=nums[idx2];
            nums[idx2]=temp;
    }
}