class Solution {
    public int subarraySum(int[] nums, int target) {
        int n=nums.length;
        int cursum=0;
        int res=0;
       
        HashMap<Integer,Integer>map=new HashMap<>();
         map.put(0,1);
        for(int i=0;i<n;i++){
            cursum+=nums[i];
            if(map.containsKey(cursum-target)){
                res+=map.get(cursum-target);
            }
            map.put(cursum,map.getOrDefault(cursum,0)+1);

        }
        return res;
    }
}