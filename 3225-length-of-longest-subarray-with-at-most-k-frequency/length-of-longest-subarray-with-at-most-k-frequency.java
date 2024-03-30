class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int len=0;
        while(i<nums.length){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            while(map.get(nums[i])>k){
               map.put(nums[j],map.get(nums[j])-1);
                    j++;
            }
            len = Math.max(len , i-j+1);
            i++;
        }
        return len;
    }
}