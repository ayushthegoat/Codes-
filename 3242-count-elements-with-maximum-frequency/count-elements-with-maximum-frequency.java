class Solution {
    public int maxFrequencyElements(int[] nums) {
    Map<Integer,Integer>map=new HashMap<>();
       for(int i:nums)map.put(i,map.getOrDefault(i,0)+1);

    
    int count=0;
    int max=Collections.max(map.values());

     for(int i:map.keySet()) {
        if(map.get(i)==max){
            count+=map.get(i);
        }
    }
    return count;
}
}