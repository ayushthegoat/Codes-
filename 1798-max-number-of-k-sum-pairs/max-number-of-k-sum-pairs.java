class Solution {
    public int maxOperations(int[] nums, int k) {
        int count=0;
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=k-nums[i];
            if(map.containsKey(temp)){
                count++;
            
            if(map.get(temp)==1){
                map.remove(temp);
            }else{
                map.put(temp,map.get(temp)-1);
            }
            }else{
            map.put(nums[i],map.getOrDefault(nums[i] , 0 ) + 1 );
            }
        }
        return count;
    }
}