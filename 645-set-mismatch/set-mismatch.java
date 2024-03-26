class Solution {
    public int[] findErrorNums(int[] nums) {
          int i=0;
            while(i<nums.length){
                int correct = nums[i]-1;
                if(nums[i]!=nums[correct]){
                swap(i,correct,nums);
                }else{
                    i++;
                }
            }
           //System.out.print(Arrays.toString(nums));
           int[] res = new int[2];
           int sm=1;
           for(int j=0;j<nums.length;j++){
                 if(nums[j]!=j+1){
                    res[0]=nums[j];
                }
                if(nums[j]==sm){
                    sm++;
                }
           }
           res[1]=sm;
        
     return res;
            
    }
     public  void swap(int i,int j,int[] nums){
         int temp=nums[i];
         nums[i]=nums[j];
         nums[j]=temp;
    }
    }
