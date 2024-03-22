class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>list=new HashSet<>();
        Arrays.sort(nums);
        int left=0;
        int right=0;
        for(int i=0;i<nums.length-2;i++){
            left=i+1;
            right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer>l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    list.add(l);
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
       return new ArrayList<>(list);
    }
}