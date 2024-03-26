class Solution {
    public int findDuplicate(int[] nums) {
        //cyclic sort;
            int i=0;
            while(i<nums.length){
                int correct = nums[i]-1;
                if(nums[i]!=nums[correct]){
                swap(i,correct,nums);
                }else{
                    i++;
                }
            }
           // System.out.print(Arrays.toString(nums));
            return nums[nums.length-1];

        
    }
     public static void swap(int i,int j,int[] nums){
         int temp=nums[i];
         nums[i]=nums[j];
         nums[j]=temp;
    }
}